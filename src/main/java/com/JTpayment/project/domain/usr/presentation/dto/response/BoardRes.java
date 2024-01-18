package com.JTpayment.project.domain.usr.presentation.dto.response;

import com.JTpayment.project.domain.board.entity.Board;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class BoardRes {
    private Long id;
    private String title;

     public static BoardRes toResponse(Board board) {
        return BoardRes.builder()
                .id(board.getId())
                .title(board.getTitle())
                .build();
    }
}
