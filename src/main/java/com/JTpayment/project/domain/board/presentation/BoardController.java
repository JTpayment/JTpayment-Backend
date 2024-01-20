package com.JTpayment.project.domain.board.presentation;

import com.JTpayment.project.domain.board.presentation.dto.request.BoardCreateRequest;
import com.JTpayment.project.domain.board.presentation.dto.response.BoardListResponse;
import com.JTpayment.project.domain.board.service.BoardCreateService;
import com.JTpayment.project.domain.board.service.BoardListService;
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
}
