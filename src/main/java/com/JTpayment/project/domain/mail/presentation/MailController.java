package com.JTpayment.project.domain.mail.presentation;

import com.JTpayment.project.domain.mail.presentation.dto.request.MailCheckReq;
import com.JTpayment.project.domain.mail.presentation.dto.request.MailReq;
import com.JTpayment.project.domain.mail.service.MailCheckService;
import com.JTpayment.project.domain.mail.service.MailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MailController {
    private final MailService mailService;
    private final MailCheckService mailCheckService;

    @PostMapping("/mail")
    public String mailSend(@RequestBody @Valid MailReq req) {
        System.out.println("email : " + req.getEmail());
        return mailService.execute(req.getEmail());
    }

    @PostMapping("/mail/check")
    public Boolean AuthCheck(@RequestBody @Valid MailCheckReq req) {
        return mailCheckService.execute(req.getEmail(), req.getCode());
    }
}
