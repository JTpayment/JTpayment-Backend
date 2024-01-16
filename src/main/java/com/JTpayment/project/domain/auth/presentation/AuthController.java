package com.JTpayment.project.domain.auth.presentation;

import com.JTpayment.project.domain.auth.presentation.dto.request.MemberLoginReq;
import com.JTpayment.project.domain.auth.presentation.dto.request.MemberSignupReq;
import com.JTpayment.project.domain.auth.presentation.dto.response.TokenRes;
import com.JTpayment.project.domain.auth.service.MemberLoginService;
import com.JTpayment.project.domain.auth.service.MemberSignupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final MemberSignupService memberSignupService;
    private final MemberLoginService memberLoginService;

    @PostMapping("/signup")
    public ResponseEntity<Void> memberSignup(@RequestBody @Valid MemberSignupReq request) {
        memberSignupService.execute(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenRes> memberLogin(@RequestBody @Valid MemberLoginReq request) {
        TokenRes response = memberLoginService.execute(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
