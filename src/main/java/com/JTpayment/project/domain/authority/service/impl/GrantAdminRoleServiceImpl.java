package com.JTpayment.project.domain.authority.service.impl;

import com.JTpayment.project.domain.auth.entity.Member;
import com.JTpayment.project.domain.auth.entity.enums.Role;
import com.JTpayment.project.domain.auth.exception.MemberNotfoundException;
import com.JTpayment.project.domain.auth.repository.MemberRepository;
import com.JTpayment.project.domain.authority.service.GrantAdminRoleService;
import com.JTpayment.project.global.util.FindMemberByEmailUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GrantAdminRoleServiceImpl implements GrantAdminRoleService {
    private final MemberRepository memberRepository;
    private final FindMemberByEmailUtil findMemberByEmailUtil;
    @Override
    public void execute(String email) {
        Member member = findMemberByEmailUtil.findMemberByEmail(email);

        member.setRole(Role.ADMIN);
        memberRepository.save(member);
    }
}
