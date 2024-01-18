package com.JTpayment.project.domain.certification.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ApplyDetailResponse {

    private String title;

    private String content;

    private String author;
}
