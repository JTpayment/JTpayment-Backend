package com.JTpayment.project.domain.board.service;

import com.JTpayment.project.domain.board.presentation.dto.response.BoardDetailResponse;

public interface BoardDetailService {

    BoardDetailResponse execute(Long cerId, Long boardId);
}
