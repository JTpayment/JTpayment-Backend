package com.JTpayment.project.domain.board.service.impl;

import com.JTpayment.project.domain.board.entity.Board;
import com.JTpayment.project.domain.board.presentation.dto.response.BoardListResponse;
import com.JTpayment.project.domain.board.presentation.dto.response.BoardResponse;
import com.JTpayment.project.domain.board.repository.BoardRepository;
import com.JTpayment.project.domain.board.service.BoardListService;
import com.JTpayment.project.domain.certification.entity.Certification;
import com.JTpayment.project.global.util.CertificationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardListServiceImpl implements BoardListService {

    private final BoardRepository boardRepository;

    private final CertificationUtil certificationUtil;

    @Override
    public BoardListResponse execute(Long cerId) {

        Certification certification = certificationUtil.findById(cerId);

        List<Board> boardList = boardRepository.findByCertification(certification);

        return BoardListResponse.builder()
                .boardList(
                        boardList.stream()
                                .map(BoardResponse::toResponse)
                                .collect(Collectors.toList())
                )
                .build();
    }
}
