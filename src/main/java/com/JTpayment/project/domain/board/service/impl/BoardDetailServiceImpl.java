package com.JTpayment.project.domain.board.service.impl;

import com.JTpayment.project.domain.board.entity.Board;
import com.JTpayment.project.domain.board.entity.Comment;
import com.JTpayment.project.domain.board.exception.MismatchCertificationException;
import com.JTpayment.project.domain.board.presentation.dto.response.BoardDetailResponse;
import com.JTpayment.project.domain.board.presentation.dto.response.CommentResponse;
import com.JTpayment.project.domain.board.repository.CommentRepository;
import com.JTpayment.project.domain.board.service.BoardDetailService;
import com.JTpayment.project.domain.certification.entity.Certification;
import com.JTpayment.project.global.util.BoardUtil;
import com.JTpayment.project.global.util.CertificationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardDetailServiceImpl implements BoardDetailService {

    private final CertificationUtil certificationUtil;

    private final BoardUtil boardUtil;

    private final CommentRepository commentRepository;

    @Override
    public BoardDetailResponse execute(Long cerId, Long boardId) {

        Certification certification = certificationUtil.findById(cerId);

        Board board = boardUtil.findById(boardId);

        if (board.getCertification() != certification) {
            throw new MismatchCertificationException();
        }

        List<Comment> commentList = commentRepository.findByBoard(board);

        return BoardDetailResponse.builder()
                .boardId(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .author(board.getAuthor().getNickName())
                .createDate(board.getCreateDate())
                .commentList(
                    commentList.stream()
                            .map(CommentResponse::toResponse)
                            .collect(Collectors.toList())
                )
                .build();
    }
}
