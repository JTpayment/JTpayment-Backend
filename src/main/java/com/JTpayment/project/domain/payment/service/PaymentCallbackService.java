package com.JTpayment.project.domain.payment.service;

import com.JTpayment.project.domain.payment.presentation.dto.request.PaymentCallbackReq;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

public interface PaymentCallbackService {
    IamportResponse<Payment> execute(PaymentCallbackReq req);
}
