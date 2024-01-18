package com.JTpayment.project.domain.authority.service.impl;

import com.JTpayment.project.domain.auth.entity.Member;
import com.JTpayment.project.domain.auth.entity.enums.Status;
import com.JTpayment.project.domain.auth.exception.MemberNotfoundException;
import com.JTpayment.project.domain.auth.repository.MemberRepository;
import com.JTpayment.project.domain.authority.service.MemberInactiveService;
import com.JTpayment.project.global.util.FindMemberByEmailUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberInactiveServiceImpl implements MemberInactiveService {
    private final MemberRepository memberRepository;
    private final FindMemberByEmailUtil findMemberByEmailUtil;

    @Override
    public void execute(String email) {
        Member member = findMemberByEmailUtil.findMemberByEmail(email);

        member.setStatus(Status.INACTIVE);
        memberRepository.save(member);
    }
}
