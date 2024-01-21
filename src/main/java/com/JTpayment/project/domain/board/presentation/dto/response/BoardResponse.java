package com.JTpayment.project.domain.board.presentation.dto.response;

import com.JTpayment.project.domain.board.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class BoardResponse {

    private Long boardId;

    private String title;

    public static BoardResponse toResponse(Board board) {
        return BoardResponse.builder()
                .boardId(board.getId())
                .title(board.getTitle())
                .build();
    }
}
