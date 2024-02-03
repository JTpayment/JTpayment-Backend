package com.JTpayment.project.domain.chat.presentation;

import com.JTpayment.project.domain.chat.presentation.dto.request.MessageSendRequest;
import com.JTpayment.project.domain.chat.service.MessageSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
public class MessageController {

    private final SimpMessageSendingOperations messageSendingOperations;

    private final MessageSaveService messageSaveService;

    @MessageMapping("/message")
    public void message(MessageSendRequest message) {
        messageSaveService.execute(message);
        messageSendingOperations.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
    }
}
