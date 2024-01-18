package com.JTpayment.project.domain.certification.presentation;

import com.JTpayment.project.domain.certification.presentation.dto.request.ApplyRequest;
import com.JTpayment.project.domain.certification.presentation.dto.request.CertificationCreateRequest;
import com.JTpayment.project.domain.certification.presentation.dto.response.ApplyDetailResponse;
import com.JTpayment.project.domain.certification.presentation.dto.response.ApplyListResponse;
import com.JTpayment.project.domain.certification.presentation.dto.response.CertificationListResponse;
import com.JTpayment.project.domain.certification.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class CertificationController {

    private final CertificationListService certificationListService;

    private final CertificationCreateService certificationCreateService;

    private final ApplyRequestService applyRequestService;

    private final ApplyListService applyListService;

    private final ApplyDetailService applyDetailService;

    @GetMapping
    public ResponseEntity<CertificationListResponse> list() {
        CertificationListResponse certificationListResponse = certificationListService.execute();
        return new ResponseEntity<>(certificationListResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody CertificationCreateRequest certificationCreateRequest) {
        certificationCreateService.execute(certificationCreateRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/request")
    public ResponseEntity<Void> request(@RequestBody ApplyRequest applyRequest) {
        applyRequestService.execute(applyRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/request/list")
    public ResponseEntity<ApplyListResponse> applyList() {
        ApplyListResponse applyListResponse = applyListService.execute();
        return new ResponseEntity<>(applyListResponse, HttpStatus.OK);
    }

    @GetMapping("/request/{applyId}")
    public ResponseEntity<ApplyDetailResponse> applyDetail(@PathVariable Long applyId) {
        ApplyDetailResponse applyDetailResponse = applyDetailService.execute(applyId);
        return new ResponseEntity<>(applyDetailResponse, HttpStatus.OK);
    }
}
