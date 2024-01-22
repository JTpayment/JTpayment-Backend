package com.JTpayment.project.domain.report.service.impl;

import com.JTpayment.project.domain.auth.entity.Member;
import com.JTpayment.project.domain.auth.entity.enums.Role;
import com.JTpayment.project.domain.auth.exception.YouNotAdminException;
import com.JTpayment.project.domain.report.entity.Report;
import com.JTpayment.project.domain.report.presentation.dto.response.ReportListResponse;
import com.JTpayment.project.domain.report.presentation.dto.response.ReportResponse;
import com.JTpayment.project.domain.report.repository.ReportRepository;
import com.JTpayment.project.domain.report.service.ReportListService;
import com.JTpayment.project.global.util.MemberUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReportListServiceImpl implements ReportListService {

    private final ReportRepository reportRepository;

    private final MemberUtil memberUtil;

    @Override
    public ReportListResponse execute() {

        Member member = memberUtil.currentMember();

        if (member.getRole() != Role.ADMIN) {
            throw new YouNotAdminException();
        }

        List<Report> reportList = reportRepository.findAll();

        return ReportListResponse.builder()
                .reportList(
                        reportList.stream()
                                .map(ReportResponse::toResponse)
                                .collect(Collectors.toList())
                )
                .build();
    }
}
