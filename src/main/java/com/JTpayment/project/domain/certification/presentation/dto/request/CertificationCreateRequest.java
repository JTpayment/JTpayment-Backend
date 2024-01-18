package com.JTpayment.project.domain.certification.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CertificationCreateRequest {

    @NotBlank(message = "제목을 입력해주세요.")
    private String title;
}
