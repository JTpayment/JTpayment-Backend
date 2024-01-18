package com.JTpayment.project.domain.authority.service.impl;

import com.JTpayment.project.domain.auth.entity.Member;
import com.JTpayment.project.domain.auth.entity.enums.Status;
import com.JTpayment.project.domain.auth.repository.MemberRepository;
import com.JTpayment.project.domain.authority.service.MemberInactiveService;
import com.JTpayment.project.global.util.MemberUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberInactiveServiceImpl implements MemberInactiveService {
    private final MemberRepository memberRepository;
    private final MemberUtil memberUtil;

    @Override
    public void execute(String email) {
        Member member = memberUtil.findMemberByEmail(email);

        member.setStatus(Status.INACTIVE);
        memberRepository.save(member);
    }
}
