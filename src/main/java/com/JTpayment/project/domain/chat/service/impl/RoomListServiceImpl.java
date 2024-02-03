package com.JTpayment.project.domain.chat.service.impl;

import com.JTpayment.project.domain.chat.entity.Room;
import com.JTpayment.project.domain.chat.presentation.dto.response.RoomListResponse;
import com.JTpayment.project.domain.chat.presentation.dto.response.RoomResponse;
import com.JTpayment.project.domain.chat.repository.RoomRepository;
import com.JTpayment.project.domain.chat.service.RoomListService;
import com.JTpayment.project.global.util.MemberUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RoomListServiceImpl implements RoomListService {

    private final RoomRepository roomRepository;

    private final MemberUtil memberUtil;

    @Override
    public RoomListResponse execute() {

        String name = memberUtil.currentMember().getNickName();

        List<Room> roomList = roomRepository.findByHostOrGuest(name, name);

        return RoomListResponse.builder()
                .roomList(
                        roomList.stream()
                                .map(RoomResponse::toResponse)
                                .collect(Collectors.toList())
                )
                .build();
    }
}
