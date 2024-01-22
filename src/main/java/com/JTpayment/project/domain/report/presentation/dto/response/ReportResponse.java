package com.JTpayment.project.domain.report.presentation.dto.response;

import com.JTpayment.project.domain.report.entity.Report;
import com.JTpayment.project.domain.report.entity.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ReportResponse {

    private Long reportId;

    private String title;

    private Type type;

    public static ReportResponse toResponse(Report report) {
        return ReportResponse.builder()
                .reportId(report.getId())
                .title(report.getTitle())
                .type(report.getType())
                .build();
    }
}
