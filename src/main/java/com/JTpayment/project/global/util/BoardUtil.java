package com.JTpayment.project.global.util;

import com.JTpayment.project.domain.board.entity.Board;
import com.JTpayment.project.domain.board.exception.BoardNotFoundException;
import com.JTpayment.project.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BoardUtil {

    private final BoardRepository boardRepository;

    public Board findById(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(BoardNotFoundException::new);
    }
}
