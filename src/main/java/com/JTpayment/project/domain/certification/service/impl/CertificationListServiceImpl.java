package com.JTpayment.project.domain.certification.service.impl;

import com.JTpayment.project.domain.certification.entity.Certification;
import com.JTpayment.project.domain.certification.presentation.dto.response.CertificationListResponse;
import com.JTpayment.project.domain.certification.presentation.dto.response.CertificationResponse;
import com.JTpayment.project.domain.certification.repository.CertificationRepository;
import com.JTpayment.project.domain.certification.service.CertificationListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CertificationListServiceImpl implements CertificationListService {

    private final CertificationRepository certificationRepository;

    @Override
    public CertificationListResponse execute() {

        System.out.println("실행됨");

        List<Certification> certificationList = certificationRepository.findAll();

        return CertificationListResponse.builder()
                .certificationList(
                        certificationList.stream()
                                .map(CertificationResponse::toResponse)
                                .collect(Collectors.toList())
                )
                .build();
    }
}
