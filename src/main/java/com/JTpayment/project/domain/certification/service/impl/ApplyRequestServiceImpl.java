package com.JTpayment.project.domain.certification.service.impl;

import com.JTpayment.project.domain.auth.entity.Member;
import com.JTpayment.project.domain.certification.entity.Apply;
import com.JTpayment.project.domain.certification.presentation.dto.request.ApplyRequest;
import com.JTpayment.project.domain.certification.repository.ApplyRepository;
import com.JTpayment.project.domain.certification.service.ApplyRequestService;
import com.JTpayment.project.global.util.MemberUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ApplyRequestServiceImpl implements ApplyRequestService {

    private final MemberUtil memberUtil;

    private final ApplyRepository applyRepository;

    @Override
    public void execute(ApplyRequest applyRequest) {

        Member member = memberUtil.currentMember();

        Apply apply = Apply.builder()
                .title(applyRequest.getTitle())
                .content(applyRequest.getContent())
                .author(member.getNickName())
                .build();

        applyRepository.save(apply);
    }
}
