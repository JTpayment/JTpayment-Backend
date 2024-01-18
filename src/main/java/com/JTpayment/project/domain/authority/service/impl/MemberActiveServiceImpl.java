package com.JTpayment.project.domain.authority.service.impl;

import com.JTpayment.project.domain.auth.entity.Member;
import com.JTpayment.project.domain.auth.entity.enums.Status;
import com.JTpayment.project.domain.auth.exception.MemberNotfoundException;
import com.JTpayment.project.domain.auth.repository.MemberRepository;
import com.JTpayment.project.domain.authority.service.MemberActiveService;
import com.JTpayment.project.global.util.FindMemberByEmailUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberActiveServiceImpl implements MemberActiveService {
    private final MemberRepository memberRepository;
    private final FindMemberByEmailUtil findMemberByEmailUtil;

    @Override
    public void execute(String email) {
        Member member = findMemberByEmailUtil.findMemberByEmail(email);

        member.setStatus(Status.ACTIVE);
        memberRepository.save(member);
    }
}
