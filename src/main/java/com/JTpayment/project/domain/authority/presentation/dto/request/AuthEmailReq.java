package com.JTpayment.project.domain.authority.presentation.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

@Getter
public class AuthEmailReq {
    @NotEmpty(message = "이메일을 입력해 주세요")
    private String email;
}
