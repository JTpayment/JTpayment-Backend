package com.JTpayment.project.global.util;

import com.JTpayment.project.domain.certification.entity.Certification;
import com.JTpayment.project.domain.certification.exception.CertificationNotFoundException;
import com.JTpayment.project.domain.certification.repository.CertificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CertificationUtil {

    private final CertificationRepository certificationRepository;

    public Certification findById(Long id) {
        return certificationRepository.findById(id)
                .orElseThrow(CertificationNotFoundException::new);
    }
}
