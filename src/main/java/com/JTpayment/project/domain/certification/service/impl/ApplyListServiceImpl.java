package com.JTpayment.project.domain.certification.service.impl;

import com.JTpayment.project.domain.certification.entity.Apply;
import com.JTpayment.project.domain.certification.presentation.dto.response.ApplyListResponse;
import com.JTpayment.project.domain.certification.presentation.dto.response.ApplyResponse;
import com.JTpayment.project.domain.certification.repository.ApplyRepository;
import com.JTpayment.project.domain.certification.service.ApplyListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ApplyListServiceImpl implements ApplyListService {

    private final ApplyRepository applyRepository;

    @Override
    public ApplyListResponse execute() {

        List<Apply> applyList = applyRepository.findAll();

        return ApplyListResponse.builder()
                .applyList(
                        applyList.stream()
                                .map(ApplyResponse::toResponse)
                                .collect(Collectors.toList())
                )
                .build();
    }
}
