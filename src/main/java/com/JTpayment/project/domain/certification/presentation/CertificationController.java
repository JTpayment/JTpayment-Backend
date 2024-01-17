package com.JTpayment.project.domain.certification.presentation;

import com.JTpayment.project.domain.certification.presentation.dto.request.ApplyRequest;
import com.JTpayment.project.domain.certification.presentation.dto.response.CertificationListResponse;
import com.JTpayment.project.domain.certification.service.ApplyRequestService;
import com.JTpayment.project.domain.certification.service.CertificationListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class CertificationController {

    private final CertificationListService certificationListService;

    private final ApplyRequestService applyRequestService;

    @GetMapping
    public ResponseEntity<CertificationListResponse> list() {
        CertificationListResponse certificationListResponse = certificationListService.execute();
        return new ResponseEntity<>(certificationListResponse, HttpStatus.OK);
    }

    @PostMapping("/request")
    public ResponseEntity<Void> request(@RequestBody ApplyRequest applyRequest) {
        applyRequestService.execute(applyRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
