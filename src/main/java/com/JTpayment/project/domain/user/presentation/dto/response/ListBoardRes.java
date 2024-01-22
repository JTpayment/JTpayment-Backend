package com.JTpayment.project.domain.user.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class ListBoardRes {
    private List<BoardRes> boardList;
}
