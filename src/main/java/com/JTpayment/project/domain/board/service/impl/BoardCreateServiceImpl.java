package com.JTpayment.project.domain.board.service.impl;

import com.JTpayment.project.domain.auth.entity.Member;
import com.JTpayment.project.domain.board.entity.Board;
import com.JTpayment.project.domain.board.presentation.dto.request.BoardCreateRequest;
import com.JTpayment.project.domain.board.repository.BoardRepository;
import com.JTpayment.project.domain.board.service.BoardCreateService;
import com.JTpayment.project.domain.certification.entity.Certification;
import com.JTpayment.project.global.util.CertificationUtil;
import com.JTpayment.project.global.util.MemberUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardCreateServiceImpl implements BoardCreateService {

    private final BoardRepository boardRepository;

    private final MemberUtil memberUtil;

    private final CertificationUtil certificationUtil;

    @Override
    public void execute(Long cerId, BoardCreateRequest boardCreateRequest) {

        Member member = memberUtil.currentMember();

        Certification certification = certificationUtil.findById(cerId);

        Board board = Board.builder()
                .title(boardCreateRequest.getTitle())
                .content(boardCreateRequest.getContent())
                .author(member)
                .createDate(LocalDate.now())
                .certification(certification)
                .build();

        boardRepository.save(board);
    }
}
