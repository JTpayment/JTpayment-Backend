package com.JTpayment.project.domain.certification.service.impl;

import com.JTpayment.project.domain.certification.entity.Apply;
import com.JTpayment.project.domain.certification.exception.ApplyNotFoundException;
import com.JTpayment.project.domain.certification.presentation.dto.response.ApplyDetailResponse;
import com.JTpayment.project.domain.certification.repository.ApplyRepository;
import com.JTpayment.project.domain.certification.service.ApplyDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ApplyDetailServiceImpl implements ApplyDetailService {

    private final ApplyRepository applyRepository;

    @Override
    public ApplyDetailResponse execute(Long applyId) {

        Apply apply = applyRepository.findById(applyId)
                .orElseThrow(ApplyNotFoundException::new);

        return ApplyDetailResponse.builder()
                .title(apply.getTitle())
                .content(apply.getContent())
                .author(apply.getAuthor())
                .build();
    }
}
