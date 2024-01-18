package com.JTpayment.project.domain.certification.service;

import com.JTpayment.project.domain.certification.presentation.dto.request.CertificationCreateRequest;

public interface CertificationCreateService {

    void execute(CertificationCreateRequest certificationCreateRequest);
}
