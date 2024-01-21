package com.JTpayment.project.domain.board.presentation;

import com.JTpayment.project.domain.board.presentation.dto.request.BoardCreateRequest;
import com.JTpayment.project.domain.board.presentation.dto.request.BoardUpdateRequest;
import com.JTpayment.project.domain.board.presentation.dto.request.CommentRequest;
import com.JTpayment.project.domain.board.presentation.dto.response.BoardDetailResponse;
import com.JTpayment.project.domain.board.presentation.dto.response.BoardListResponse;
import com.JTpayment.project.domain.board.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/certification/{cerId}")
public class BoardController {

    private final BoardCreateService boardCreateService;

    private final BoardListService boardListService;

    private final BoardDetailService boardDetailService;

    private final BoardUpdateService boardUpdateService;

    private final BoardDeleteService boardDeleteService;

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<Void> create(@PathVariable Long cerId, @RequestBody BoardCreateRequest boardCreateRequest) {
        boardCreateService.execute(cerId, boardCreateRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<BoardListResponse> list(@PathVariable Long cerId) {
        BoardListResponse boardListResponse = boardListService.execute(cerId);
        return new ResponseEntity<>(boardListResponse, HttpStatus.OK);
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<BoardDetailResponse> detail(@PathVariable Long cerId, @PathVariable Long boardId) {
        BoardDetailResponse boardDetailResponse = boardDetailService.execute(cerId, boardId);
        return new ResponseEntity<>(boardDetailResponse, HttpStatus.OK);
    }

    @PatchMapping("/{boardId}")
    public ResponseEntity<Void> update(@PathVariable Long boardId, @RequestBody BoardUpdateRequest boardUpdateRequest) {
        boardUpdateService.execute(boardId, boardUpdateRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{boardId}")
    public ResponseEntity<Void> delete(@PathVariable Long boardId) {
        boardDeleteService.execute(boardId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{boardId}/comment")
    public ResponseEntity<Void> comment(@PathVariable Long boardId, @RequestBody CommentRequest commentRequest) {
        commentService.execute(boardId, commentRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
