package com.JTpayment.project.domain.authority.service.impl;

import com.JTpayment.project.domain.auth.entity.Member;
import com.JTpayment.project.domain.auth.entity.enums.Role;
import com.JTpayment.project.domain.auth.exception.MemberNotfoundException;
import com.JTpayment.project.domain.auth.repository.MemberRepository;
import com.JTpayment.project.domain.authority.service.GrantAdminRoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class GrantAdminRoleServiceImpl implements GrantAdminRoleService {
    private final MemberRepository memberRepository;

    @Override
    public void execute(String email) {
        log.info("email: {}", email);
        Member member = memberRepository.findMemberByEmail(email)
                .orElseThrow(MemberNotfoundException::new);

        member.setRole(Role.ADMIN);
        memberRepository.save(member);
    }
}
