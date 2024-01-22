package com.JTpayment.project.domain.report.service.impl;

import com.JTpayment.project.domain.auth.entity.Member;
import com.JTpayment.project.domain.auth.entity.enums.Role;
import com.JTpayment.project.domain.auth.exception.YouNotAdminException;
import com.JTpayment.project.domain.report.entity.Report;
import com.JTpayment.project.domain.report.presentation.dto.response.ReportDetailResponse;
import com.JTpayment.project.domain.report.service.ReportDetailService;
import com.JTpayment.project.global.util.MemberUtil;
import com.JTpayment.project.global.util.ReportUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReportDetailServiceImpl implements ReportDetailService {

    private final ReportUtil reportUtil;

    private final MemberUtil memberUtil;

    @Override
    public ReportDetailResponse execute(Long reportId) {

        Member member = memberUtil.currentMember();

        if (member.getRole() != Role.ADMIN) {
            throw new YouNotAdminException();
        }

        Report report = reportUtil.findById(reportId);

        return ReportDetailResponse.builder()
                .reportId(report.getId())
                .title(report.getTitle())
                .content(report.getContent())
                .author(report.getAuthor().getNickName())
                .reportedMember(report.getReportedMember().getEmail())
                .createDate(report.getCreateDate())
                .type(report.getType())
                .build();
    }
}
