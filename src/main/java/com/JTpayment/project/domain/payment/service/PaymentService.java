package com.JTpayment.project.domain.payment.service;

import com.JTpayment.project.domain.payment.presentation.dto.request.PayReq;

public interface PaymentService {
    PayReq execute(String orderUid);
}
