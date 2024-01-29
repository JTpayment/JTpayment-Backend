package com.JTpayment.project.domain.payment.service.impl;

import com.JTpayment.project.domain.auth.entity.Member;
import com.JTpayment.project.domain.payment.entity.Order;
import com.JTpayment.project.domain.payment.entity.Payment;
import com.JTpayment.project.domain.payment.entity.enums.PaymentStatus;
import com.JTpayment.project.domain.payment.repository.OrderRepository;
import com.JTpayment.project.domain.payment.repository.PaymentRepository;
import com.JTpayment.project.domain.payment.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;

    @Override
    public Order execute(Member member, Long price) {
        Payment payment = Payment.builder()
                .price(price)
                .status(PaymentStatus.READY)
                .build();
        paymentRepository.save(payment);

        Order order = Order.builder()
                .member(member)
                .price(price)
                .itemName("비법넷 크레딧 결제")
                .orderUid(UUID.randomUUID().toString())
                .payment(payment)
                .build();

        return orderRepository.save(order);
    }
}
