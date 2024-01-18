package com.JTpayment.project.global.util;

import com.JTpayment.project.domain.auth.entity.Member;
import com.JTpayment.project.domain.auth.exception.MemberNotfoundException;
import com.JTpayment.project.domain.auth.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberUtil {

    private final MemberRepository memberRepository;

    public Member currentMember() {
        String id = SecurityContextHolder.getContext().getAuthentication().getName();
        return memberRepository.findMemberByLoginId(id)
                .orElseThrow(MemberNotfoundException::new);
    }

    public Member findMemberByEmail(String email) {
        return memberRepository.findMemberByEmail(email)
                .orElseThrow(MemberNotfoundException::new);
    }
}
