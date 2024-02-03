package com.JTpayment.project.domain.chat.service.impl;

import com.JTpayment.project.domain.chat.entity.Message;
import com.JTpayment.project.domain.chat.entity.Room;
import com.JTpayment.project.domain.chat.exception.RoomNotFoundException;
import com.JTpayment.project.domain.chat.presentation.dto.request.MessageSendRequest;
import com.JTpayment.project.domain.chat.repository.MessageRepository;
import com.JTpayment.project.domain.chat.repository.RoomRepository;
import com.JTpayment.project.domain.chat.service.MessageSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class MessageSaveServiceImpl implements MessageSaveService {

    private final MessageRepository messageRepository;

    private final RoomRepository roomRepository;

    @Override
    public void execute(MessageSendRequest messageSendRequest) {

        Room room = roomRepository.findByRoomId(messageSendRequest.getRoomId())
                .orElseThrow(RoomNotFoundException::new);

        Message message = Message.builder()
                .sender(messageSendRequest.getSender())
                .message(messageSendRequest.getMessage())
                .sendTime(LocalDateTime.now())
                .room(room)
                .build();

        messageRepository.save(message);

        room.setLastMessage(messageSendRequest.getMessage());
        roomRepository.save(room);
    }
}
