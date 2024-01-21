package com.JTpayment.project.domain.board.service;

import com.JTpayment.project.domain.board.presentation.dto.response.BoardListResponse;

public interface BoardListService {

    BoardListResponse execute(Long cerId);
}
