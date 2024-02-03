package com.JTpayment.project.domain.chat.presentation;

import com.JTpayment.project.domain.chat.presentation.dto.response.MessageListResponse;
import com.JTpayment.project.domain.chat.presentation.dto.response.RoomListResponse;
import com.JTpayment.project.domain.chat.service.CreateRoomService;
import com.JTpayment.project.domain.chat.service.MessageListService;
import com.JTpayment.project.domain.chat.service.RoomListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/chat/room")
public class RoomController {

    private final CreateRoomService createRoomService;

    private final RoomListService roomListService;

    private final MessageListService messageListService;

    @PostMapping("/create/{memberId}")
    public ResponseEntity<Void> createRoom(@PathVariable Long memberId) {
        createRoomService.execute(memberId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<RoomListResponse> roomList() {
        RoomListResponse roomListResponse = roomListService.execute();
        return new ResponseEntity<>(roomListResponse, HttpStatus.OK);
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<MessageListResponse> messageList(@PathVariable String roomId) {
        MessageListResponse messageListResponse = messageListService.execute(roomId);
        return new ResponseEntity<>(messageListResponse, HttpStatus.OK);
    }
}
