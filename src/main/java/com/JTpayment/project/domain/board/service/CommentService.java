package com.JTpayment.project.domain.board.service;

import com.JTpayment.project.domain.board.presentation.dto.request.CommentRequest;

public interface CommentService {

    void execute(Long boardId, CommentRequest commentRequest);
}
