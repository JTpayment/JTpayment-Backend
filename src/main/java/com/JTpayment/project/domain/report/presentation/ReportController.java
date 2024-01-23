package com.JTpayment.project.domain.report.presentation;

import com.JTpayment.project.domain.report.presentation.dto.request.ReportRequest;
import com.JTpayment.project.domain.report.presentation.dto.response.ReportDetailResponse;
import com.JTpayment.project.domain.report.presentation.dto.response.ReportListResponse;
import com.JTpayment.project.domain.report.service.ReportDetailService;
import com.JTpayment.project.domain.report.service.ReportListService;
import com.JTpayment.project.domain.report.service.ReportService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    private final ReportListService reportListService;

    private final ReportDetailService reportDetailService;

    @PostMapping
    public ResponseEntity<Void> report(@RequestBody @Valid ReportRequest reportRequest) {
        reportService.execute(reportRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ReportListResponse> list() {
        ReportListResponse reportListResponse = reportListService.execute();
        return new ResponseEntity<>(reportListResponse, HttpStatus.OK);
    }

    @GetMapping("/{reportId}")
    public ResponseEntity<ReportDetailResponse> detail(@PathVariable Long reportId) {
        ReportDetailResponse reportDetailResponse = reportDetailService.execute(reportId);
        return new ResponseEntity<>(reportDetailResponse, HttpStatus.OK);
    }
}
