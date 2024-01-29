package com.JTpayment.project.domain.payment.service;

import com.JTpayment.project.domain.auth.entity.Member;
import com.JTpayment.project.domain.payment.entity.Order;

public interface OrderService {
    Order execute(Member member, Long price);
}
