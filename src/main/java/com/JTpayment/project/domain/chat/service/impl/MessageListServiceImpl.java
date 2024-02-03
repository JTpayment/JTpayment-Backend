package com.JTpayment.project.domain.chat.service.impl;

import com.JTpayment.project.domain.chat.entity.Message;
import com.JTpayment.project.domain.chat.entity.Room;
import com.JTpayment.project.domain.chat.exception.RoomNotFoundException;
import com.JTpayment.project.domain.chat.exception.YouNotParticipateInException;
import com.JTpayment.project.domain.chat.presentation.dto.response.MessageListResponse;
import com.JTpayment.project.domain.chat.presentation.dto.response.MessageResponse;
import com.JTpayment.project.domain.chat.repository.MessageRepository;
import com.JTpayment.project.domain.chat.repository.RoomRepository;
import com.JTpayment.project.domain.chat.service.MessageListService;
import com.JTpayment.project.global.util.MemberUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MessageListServiceImpl implements MessageListService {

    private final MessageRepository messageRepository;

    private final RoomRepository roomRepository;

    private final MemberUtil memberUtil;

    @Override
    public MessageListResponse execute(String roomId) {

        Room room = roomRepository.findByRoomId(roomId)
                .orElseThrow(RoomNotFoundException::new);

        containMemberCheck(room);

        List<Message> messageList = messageRepository.findByRoom(room);

        return MessageListResponse.builder()
                .MessageList(
                        messageList.stream()
                                .map(MessageResponse::toResponse)
                                .collect(Collectors.toList())
                )
                .build();
    }

    private void containMemberCheck(Room room) {

        String name = memberUtil.currentMember().getNickName();

        if (!room.getHost().equals(name) && !room.getGuest().equals(name)) {
            throw new YouNotParticipateInException();
        }
    }
}
