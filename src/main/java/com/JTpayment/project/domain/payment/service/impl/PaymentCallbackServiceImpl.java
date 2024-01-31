package com.JTpayment.project.domain.payment.service.impl;

import com.JTpayment.project.domain.auth.service.MemberCreditService;
import com.JTpayment.project.domain.payment.entity.Order;
import com.JTpayment.project.domain.payment.entity.enums.PaymentStatus;
import com.JTpayment.project.domain.payment.presentation.dto.request.PaymentCallbackReq;
import com.JTpayment.project.domain.payment.exception.OrderNotFoundException;
import com.JTpayment.project.domain.payment.repository.OrderRepository;
import com.JTpayment.project.domain.payment.repository.PaymentRepository;
import com.JTpayment.project.domain.payment.service.PaymentCallbackService;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.request.CancelData;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.math.BigDecimal;

@Service
@Transactional
@RequiredArgsConstructor
public class PaymentCallbackServiceImpl implements PaymentCallbackService {
    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;
    private final IamportClient iamportClient;
    private final MemberCreditService memberCreditService;

    @Override
    public IamportResponse<Payment> execute(PaymentCallbackReq req) {
        try{
            IamportResponse<Payment> res = iamportClient.paymentByImpUid(req.getPaymentUid());
            Order order = orderRepository.findOrderAndPayment(req.getOrderUid())
                    .orElseThrow(OrderNotFoundException::new);

            if (!res.getResponse().getStatus().equals("paid")){
                orderRepository.delete(order);
                paymentRepository.delete(order.getPayment());

                throw new RuntimeException("결제가 완료되지 않았습니다.");
            }

            Long price = order.getPayment().getPrice();
            int iamportPrice = res.getResponse().getAmount().intValue();

            if(iamportPrice != price){
                orderRepository.delete(order);
                paymentRepository.delete(order.getPayment());

                iamportClient.cancelPaymentByImpUid(new CancelData(res.getResponse().getImpUid(), true, new BigDecimal(iamportPrice)));

                throw new RuntimeException("결제 금액이 일치하지 않습니다.");
            }

            order.getPayment().changePaymentBySuccess(PaymentStatus.OK, res.getResponse().getImpUid());
            memberCreditService.execute(order.getMember().getMemberId(), order.getPayment().getPrice());

            return res;
        }catch (IamportResponseException e){
            throw new RuntimeException(e);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
