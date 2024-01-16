package com.JTpayment.project.domain.certification.presentation;

import com.JTpayment.project.domain.certification.presentation.dto.response.CertificationListResponse;
import com.JTpayment.project.domain.certification.service.CertificationListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class CertificationController {

    private final CertificationListService certificationListService;

    @GetMapping
    public ResponseEntity<CertificationListResponse> list() {
        CertificationListResponse certificationListResponse = certificationListService.execute();
        return new ResponseEntity<>(certificationListResponse, HttpStatus.OK);
    }
}
