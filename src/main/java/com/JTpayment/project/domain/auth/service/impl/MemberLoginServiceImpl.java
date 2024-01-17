package com.JTpayment.project.domain.auth.service.impl;

import com.JTpayment.project.domain.auth.entity.Member;
import com.JTpayment.project.domain.auth.exception.MemberNotfoundException;
import com.JTpayment.project.domain.auth.presentation.dto.request.MemberLoginReq;
import com.JTpayment.project.domain.auth.presentation.dto.response.TokenRes;
import com.JTpayment.project.domain.auth.repository.MemberRepository;
import com.JTpayment.project.domain.auth.service.MemberLoginService;
import com.JTpayment.project.global.error.BasicException;
import com.JTpayment.project.global.error.ErrorCode;
import com.JTpayment.project.global.security.jwt.TokenGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class MemberLoginServiceImpl implements MemberLoginService {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final TokenGenerator tokenGenerator;

    @Override
    public TokenRes execute(MemberLoginReq req) {
        Member member = memberRepository.findMemberByLoginId(req.getMemberId())
                .orElseThrow(MemberNotfoundException::new);

        if(!passwordEncoder.matches(req.getPassword(), member.getPassword())){
            throw new BasicException(ErrorCode.PASSWORD_INVALID);
        }

        return tokenGenerator.getToken(req.getMemberId());
    }
}
