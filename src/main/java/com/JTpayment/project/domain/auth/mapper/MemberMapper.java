package com.JTpayment.project.domain.auth.mapper;

import com.JTpayment.project.domain.auth.entity.Member;
import com.JTpayment.project.domain.auth.presentation.dto.request.MemberSignupReq;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {
    public Member signupReqToMember(MemberSignupReq signupReq, String password) {
        return Member.builder()
                .loginId(signupReq.getId())
                .password(signupReq.getPassword())
                .nickName(signupReq.getNickname())
                .email(signupReq.getEmail())
                .build();
    }
}
