package com.JTpayment.project.domain.report.service;

import com.JTpayment.project.domain.report.presentation.dto.request.ReportRequest;

public interface ReportService {

    void execute(ReportRequest reportRequest);
}
