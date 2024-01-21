package com.JTpayment.project.domain.board.service.impl;

import com.JTpayment.project.domain.auth.entity.Member;
import com.JTpayment.project.domain.board.entity.Board;
import com.JTpayment.project.domain.board.exception.MismatchAuthorException;
import com.JTpayment.project.domain.board.presentation.dto.request.BoardUpdateRequest;
import com.JTpayment.project.domain.board.repository.BoardRepository;
import com.JTpayment.project.domain.board.service.BoardUpdateService;
import com.JTpayment.project.global.util.BoardUtil;
import com.JTpayment.project.global.util.MemberUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardUpdateServiceImpl implements BoardUpdateService {

    private final BoardRepository boardRepository;

    private final BoardUtil boardUtil;

    private final MemberUtil memberUtil;

    @Override
    public void execute(Long boardId, BoardUpdateRequest boardUpdateRequest) {

        Board board = boardUtil.findById(boardId);

        Member member = memberUtil.currentMember();

        if (board.getAuthor() != member) {
            throw new MismatchAuthorException();
        }

        board.update(boardUpdateRequest.getTitle(), boardUpdateRequest.getContent());

        boardRepository.save(board);
    }
}
