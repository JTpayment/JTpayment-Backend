package com.JTpayment.project.domain.board.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class BoardDetailResponse {

    private Long boardId;

    private String title;

    private String content;

    private String author;

    private LocalDate createDate;

    private List<CommentResponse> commentList;
}
