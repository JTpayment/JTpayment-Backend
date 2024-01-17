package com.JTpayment.project.domain.auth.service.impl;

import com.JTpayment.project.domain.auth.mapper.MemberMapper;
import com.JTpayment.project.domain.auth.presentation.dto.request.MemberSignupReq;
import com.JTpayment.project.domain.auth.repository.MemberRepository;
import com.JTpayment.project.domain.auth.service.MemberSignupService;
import com.JTpayment.project.global.error.BasicException;
import com.JTpayment.project.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberSignupServiceImpl implements MemberSignupService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void execute(MemberSignupReq req) {
        if(memberRepository.existsByLoginId(req.getId()))
            throw new BasicException(ErrorCode.DUPLICATED_ID);

        if(memberRepository.existsByNickName(req.getNickname()))
            throw new BasicException(ErrorCode.DUPLICATED_NICKNAME);

        if(memberRepository.existsByEmail(req.getEmail()))
            throw new BasicException(ErrorCode.DUPLICATED_EMAIL);

        memberRepository.save(memberMapper.signupReqToMember(req,passwordEncoder.encode((req.getPassword()))));
    }
}
