package com.JTpayment.project.domain.payment.presentation.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
public class PayReq {
    private String orderUid;
    private String itemName;
    private String loginId;
    private Long paymentPrice;
    private String buyerEmail;

    @Builder
    public PayReq(String orderUid, String itemName, String loginId, Long paymentPrice, String buyerEmail) {
        this.orderUid = orderUid;
        this.itemName = itemName;
        this.loginId = loginId;
        this.paymentPrice = paymentPrice;
        this.buyerEmail = buyerEmail;
    }
}
