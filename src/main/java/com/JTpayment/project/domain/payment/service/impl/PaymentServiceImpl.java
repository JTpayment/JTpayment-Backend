package com.JTpayment.project.domain.payment.service.impl;

import com.JTpayment.project.domain.payment.entity.Order;
import com.JTpayment.project.domain.payment.presentation.dto.request.PayReq;
import com.JTpayment.project.domain.payment.exception.OrderNotFoundException;
import com.JTpayment.project.domain.payment.repository.OrderRepository;
import com.JTpayment.project.domain.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final OrderRepository orderRepository;

    @Override
    public PayReq execute(String orderUid) {
        Order order = orderRepository.findOrderAndPaymentAndMember(orderUid)
                .orElseThrow(OrderNotFoundException::new);

        return PayReq.builder()
                .loginId(order.getMember().getLoginId())
                .buyerEmail(order.getMember().getEmail())
                .paymentPrice(order.getPayment().getPrice())
                .itemName(order.getItemName())
                .orderUid(order.getOrderUid())
                .build();
    }
}
