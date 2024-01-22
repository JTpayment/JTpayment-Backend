package com.JTpayment.project.domain.report.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ReportListResponse {

    private List<ReportResponse> reportList;
}
