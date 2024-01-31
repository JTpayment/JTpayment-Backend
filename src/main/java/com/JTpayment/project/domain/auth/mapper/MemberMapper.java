package com.JTpayment.project.domain.auth.mapper;

import com.JTpayment.project.domain.auth.entity.Member;
import com.JTpayment.project.domain.auth.entity.enums.Role;
import com.JTpayment.project.domain.auth.entity.enums.Status;
import com.JTpayment.project.domain.auth.presentation.dto.request.MemberSignupReq;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberMapper {
    private final PasswordEncoder passwordEncoder;

    public Member signupReqToMember(MemberSignupReq signupReq, String password) {
        return Member.builder()
                .loginId(signupReq.getId())
                .password(passwordEncoder.encode(signupReq.getPassword()))
                .nickName(signupReq.getNickname())
                .email(signupReq.getEmail())
                .status(Status.ACTIVE)
                .role(Role.USER)
                .credit(0L)
                .build();
    }
}
