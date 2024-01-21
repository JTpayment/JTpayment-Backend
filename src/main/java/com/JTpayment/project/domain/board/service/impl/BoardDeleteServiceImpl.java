package com.JTpayment.project.domain.board.service.impl;

import com.JTpayment.project.domain.auth.entity.Member;
import com.JTpayment.project.domain.board.entity.Board;
import com.JTpayment.project.domain.board.exception.MismatchAuthorException;
import com.JTpayment.project.domain.board.repository.BoardRepository;
import com.JTpayment.project.domain.board.service.BoardDeleteService;
import com.JTpayment.project.global.util.BoardUtil;
import com.JTpayment.project.global.util.MemberUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardDeleteServiceImpl implements BoardDeleteService {

    private final BoardRepository boardRepository;

    private final BoardUtil boardUtil;

    private final MemberUtil memberUtil;

    @Override
    public void execute(Long boardId) {

        Board board = boardUtil.findById(boardId);

        Member member = memberUtil.currentMember();

        if (board.getAuthor() != member) {
            throw new MismatchAuthorException();
        }

        boardRepository.delete(board);
    }
}
