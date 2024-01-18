package com.JTpayment.project.domain.certification.presentation.dto.response;

import com.JTpayment.project.domain.certification.entity.Apply;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ApplyResponse {

    private Long applyId;

    private String title;

    public static ApplyResponse toResponse(Apply apply) {

        return ApplyResponse.builder()
                .applyId(apply.getId())
                .title(apply.getTitle())
                .build();
    }
}
