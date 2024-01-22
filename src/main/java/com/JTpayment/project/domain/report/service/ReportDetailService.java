package com.JTpayment.project.domain.report.service;

import com.JTpayment.project.domain.report.presentation.dto.response.ReportDetailResponse;

public interface ReportDetailService {

    ReportDetailResponse execute(Long reportId);
}
