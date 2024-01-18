package com.JTpayment.project.domain.board.presentation;

import com.JTpayment.project.domain.board.presentation.dto.request.BoardCreateRequest;
import com.JTpayment.project.domain.board.service.BoardCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/certification/{certification_id}")
public class BoardController {

    private final BoardCreateService boardCreateService;

    @PostMapping
    public ResponseEntity<Void> create(@PathVariable Long certification_id, @RequestBody BoardCreateRequest boardCreateRequest) {
        boardCreateService.execute(certification_id, boardCreateRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
