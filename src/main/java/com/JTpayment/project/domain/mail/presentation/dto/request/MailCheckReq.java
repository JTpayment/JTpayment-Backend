package com.JTpayment.project.domain.mail.presentation.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class MailCheckReq {
    @Email
    @NotEmpty(message = "이메일을 입력해 주세요")
    private String email;

    @NotEmpty(message = "인증번호를 입력해 주세요")
    private String code;
}
