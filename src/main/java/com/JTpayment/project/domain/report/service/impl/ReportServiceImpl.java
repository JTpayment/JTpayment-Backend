package com.JTpayment.project.domain.report.service.impl;

import com.JTpayment.project.domain.auth.entity.Member;
import com.JTpayment.project.domain.report.entity.Report;
import com.JTpayment.project.domain.report.entity.enums.Type;
import com.JTpayment.project.domain.report.presentation.dto.request.ReportRequest;
import com.JTpayment.project.domain.report.repository.ReportRepository;
import com.JTpayment.project.domain.report.service.ReportService;
import com.JTpayment.project.global.util.MemberUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    private final MemberUtil memberUtil;

    @Override
    public void execute(ReportRequest reportRequest) {

        Member author = memberUtil.currentMember();

        Member reportedMember = memberUtil.findMemberByEmail(reportRequest.getEmail());

        Report report = Report.builder()
                .title(reportRequest.getTitle())
                .content(reportRequest.getContent())
                .author(author)
                .reportedMember(reportedMember)
                .createDate(LocalDate.now())
                .type(Type.from(reportRequest.getType()))
                .build();

        reportRepository.save(report);
    }
}
