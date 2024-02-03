package com.JTpayment.project.domain.chat.presentation.dto.response;

import com.JTpayment.project.domain.chat.entity.Message;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class MessageResponse {

    private Long messageId;

    private String sender;

    private String message;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime sendTime;

    public static MessageResponse toResponse(Message message) {
        return MessageResponse.builder()
                .messageId(message.getId())
                .sender(message.getSender())
                .message(message.getMessage())
                .sendTime(message.getSendTime())
                .build();
    }
}
