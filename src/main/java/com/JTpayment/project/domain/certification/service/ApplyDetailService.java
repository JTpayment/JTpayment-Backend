package com.JTpayment.project.domain.certification.service;

import com.JTpayment.project.domain.certification.presentation.dto.response.ApplyDetailResponse;

public interface ApplyDetailService {

    ApplyDetailResponse execute(Long applyId);
}
