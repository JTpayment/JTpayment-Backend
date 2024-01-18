package com.JTpayment.project.domain.certification.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class ApplyListResponse {

    private List<ApplyResponse> applyList;
}
