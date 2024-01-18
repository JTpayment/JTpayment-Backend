package com.JTpayment.project.domain.certification.service.impl;

import com.JTpayment.project.domain.certification.entity.Certification;
import com.JTpayment.project.domain.certification.presentation.dto.request.CertificationCreateRequest;
import com.JTpayment.project.domain.certification.repository.CertificationRepository;
import com.JTpayment.project.domain.certification.service.CertificationCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CertificationCreateServiceImpl implements CertificationCreateService {

    private final CertificationRepository certificationRepository;

    @Override
    public void execute(CertificationCreateRequest certificationCreateRequest) {

        Certification certification = Certification.builder()
                .title(certificationCreateRequest.getTitle())
                .build();

        certificationRepository.save(certification);
    }
}
