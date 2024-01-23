package com.JTpayment.project.global.util;

import com.JTpayment.project.domain.report.entity.Report;
import com.JTpayment.project.domain.report.exception.ReportNotFoundException;
import com.JTpayment.project.domain.report.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReportUtil {

    private final ReportRepository reportRepository;

    public Report findById(Long id) {
        return reportRepository.findById(id)
                .orElseThrow(ReportNotFoundException::new);
    }
}
