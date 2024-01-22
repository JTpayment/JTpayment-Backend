package com.JTpayment.project.domain.report.presentation.dto.response;

import com.JTpayment.project.domain.report.entity.enums.Type;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public class ReportDetailResponse {

    private Long reportId;

    private String title;

    private String content;

    private String author;

    private String reportedMember;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate createDate;

    private Type type;
}
