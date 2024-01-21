package com.JTpayment.project.domain.board.service;

import com.JTpayment.project.domain.board.presentation.dto.request.BoardCreateRequest;

public interface BoardCreateService {

    void execute(Long cerId, BoardCreateRequest boardCreateRequest);
}
