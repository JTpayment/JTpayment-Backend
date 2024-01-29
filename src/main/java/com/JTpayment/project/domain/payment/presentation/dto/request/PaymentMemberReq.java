package com.JTpayment.project.domain.payment.presentation.dto.request;

import lombok.Data;

@Data
public class PaymentMemberReq {
    private String loginId;
    private String email;
}
