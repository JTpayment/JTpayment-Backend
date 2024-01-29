package com.JTpayment.project.domain.payment.presentation.dto.request;

import lombok.Data;

@Data
public class PaymentCallbackReq {
    String paymentUid;
    String orderUid;
}
