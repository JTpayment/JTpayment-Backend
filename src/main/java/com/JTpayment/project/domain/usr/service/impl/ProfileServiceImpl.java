package com.JTpayment.project.domain.usr.service.impl;

import com.JTpayment.project.domain.auth.entity.Member;
import com.JTpayment.project.domain.auth.exception.MemberNotfoundException;
import com.JTpayment.project.domain.auth.repository.MemberRepository;
import com.JTpayment.project.domain.usr.presentation.dto.request.ProfileReq;
import com.JTpayment.project.domain.usr.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final MemberRepository memberRepository;

    @Override
    public ProfileReq execute(String loginId) {
        Member member = memberRepository.findMemberByLoginId(loginId)
                .orElseThrow(MemberNotfoundException::new);

        return ProfileReq.builder()
                .nickname(member.getNickName())
                .email(member.getEmail())
                .build();
    }
}
