package com.JTpayment.project.domain.auth.service.impl;

import com.JTpayment.project.domain.auth.entity.Member;
import com.JTpayment.project.domain.auth.exception.MemberNotfoundException;
import com.JTpayment.project.domain.auth.repository.MemberRepository;
import com.JTpayment.project.domain.auth.service.MemberCreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberCreditServiceimpl implements MemberCreditService {
    private final MemberRepository memberRepository;

    @Override
    public void execute(Long memberId, Long price) {
        Member member = memberRepository.findMemberByMemberId(memberId)
                .orElseThrow(MemberNotfoundException::new);

        Long currentCredit = member.getCredit();
        member.setCredit(currentCredit + price);

        memberRepository.save(member);
    }
}
