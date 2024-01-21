package com.JTpayment.project.domain.board.service;

import com.JTpayment.project.domain.board.presentation.dto.request.BoardUpdateRequest;

public interface BoardUpdateService {

    void execute(Long boardId, BoardUpdateRequest boardUpdateRequest);
}
