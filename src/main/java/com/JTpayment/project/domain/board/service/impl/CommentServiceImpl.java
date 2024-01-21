package com.JTpayment.project.domain.board.service.impl;

import com.JTpayment.project.domain.auth.entity.Member;
import com.JTpayment.project.domain.board.entity.Board;
import com.JTpayment.project.domain.board.entity.Comment;
import com.JTpayment.project.domain.board.presentation.dto.request.CommentRequest;
import com.JTpayment.project.domain.board.repository.CommentRepository;
import com.JTpayment.project.domain.board.service.CommentService;
import com.JTpayment.project.global.util.BoardUtil;
import com.JTpayment.project.global.util.MemberUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    private final BoardUtil boardUtil;

    private final MemberUtil memberUtil;

    @Override
    public void execute(Long boardId, CommentRequest commentRequest) {

        Board board = boardUtil.findById(boardId);

        Member member = memberUtil.currentMember();

        Comment comment = Comment.builder()
                .comment(commentRequest.getComment())
                .author(member)
                .createDate(LocalDate.now())
                .board(board)
                .build();

        commentRepository.save(comment);
    }
}
