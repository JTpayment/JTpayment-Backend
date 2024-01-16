package com.JTpayment.project.domain.certification.presentation.dto.response;

import com.JTpayment.project.domain.certification.entity.Certification;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CertificationResponse {

    private Long certificationId;

    private String title;

    public static CertificationResponse toResponse(Certification certification) {

        return CertificationResponse.builder()
                .certificationId(certification.getId())
                .title(certification.getTitle())
                .build();
    }
}
