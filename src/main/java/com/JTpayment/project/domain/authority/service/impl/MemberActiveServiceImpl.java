package com.JTpayment.project.domain.authority.service.impl;

import com.JTpayment.project.domain.auth.entity.Member;
import com.JTpayment.project.domain.auth.entity.enums.Status;
import com.JTpayment.project.domain.auth.exception.MemberNotfoundException;
import com.JTpayment.project.domain.auth.repository.MemberRepository;
import com.JTpayment.project.domain.authority.service.MemberActiveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberActiveServiceImpl implements MemberActiveService {
    private final MemberRepository memberRepository;

    @Override
    public void execute(String email) {
        Member member = memberRepository.findMemberByEmail(email)
                .orElseThrow(MemberNotfoundException::new);

        member.setStatus(Status.ACTIVE);
        memberRepository.save(member);
    }
}
