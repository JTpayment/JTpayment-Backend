package com.JTpayment.project.domain.report.presentation;

import com.JTpayment.project.domain.report.presentation.dto.request.ReportRequest;
import com.JTpayment.project.domain.report.service.ReportService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;

    @PostMapping
    public ResponseEntity<Void> report(@RequestBody @Valid ReportRequest reportRequest) {
        reportService.execute(reportRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
