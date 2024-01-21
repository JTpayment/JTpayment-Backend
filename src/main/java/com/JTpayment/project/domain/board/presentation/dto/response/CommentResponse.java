package com.JTpayment.project.domain.board.presentation.dto.response;

import com.JTpayment.project.domain.board.entity.Comment;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public class CommentResponse {

    private Long commentId;

    private String author;

    private String comment;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate createDate;

    public static CommentResponse toResponse(Comment comment) {
        return CommentResponse.builder()
                .commentId(comment.getId())
                .author(comment.getAuthor().getNickName())
                .comment(comment.getComment())
                .createDate(comment.getCreateDate())
                .build();
    }
}
