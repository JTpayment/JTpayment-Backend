package com.JTpayment.project.domain.user.service.impl;

import com.JTpayment.project.domain.auth.entity.Member;
import com.JTpayment.project.domain.board.entity.Board;
import com.JTpayment.project.domain.board.repository.BoardRepository;
import com.JTpayment.project.domain.user.presentation.dto.response.BoardRes;
import com.JTpayment.project.domain.user.presentation.dto.response.ListBoardRes;
import com.JTpayment.project.domain.user.service.MypageService;
import com.JTpayment.project.global.util.MemberUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MypageServiceImpl implements MypageService {
    private final MemberUtil memberUtil;
    private final BoardRepository boardRepository;

    @Override
    public ListBoardRes execute() {
        Member member = memberUtil.currentMember();
        List<Board> boardList = boardRepository.findByAuthor(member);


        return ListBoardRes.builder()
                .boardList(
                        boardList.stream()
                            .map(BoardRes::toResponse)
                            .collect(Collectors.toList())
                )
                .build();
    }
}