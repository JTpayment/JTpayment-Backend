package com.JTpayment.project.domain.chat.service.impl;

import com.JTpayment.project.domain.auth.entity.Member;
import com.JTpayment.project.domain.auth.exception.MemberNotfoundException;
import com.JTpayment.project.domain.auth.repository.MemberRepository;
import com.JTpayment.project.domain.chat.entity.Room;
import com.JTpayment.project.domain.chat.repository.RoomRepository;
import com.JTpayment.project.domain.chat.service.CreateRoomService;
import com.JTpayment.project.global.util.MemberUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateRoomServiceImpl implements CreateRoomService {

    private final RoomRepository chatRoomRepository;

    private final MemberUtil memberUtil;

    private final MemberRepository memberRepository;

    @Override
    public void execute(Long memberId) {

        Member guest = memberUtil.currentMember();

        Member host = memberRepository.findMemberByMemberId(memberId)
                .orElseThrow(MemberNotfoundException::new);

        Room room = Room.builder()
                .roomId(UUID.randomUUID().toString())
                .host(host.getNickName())
                .guest(guest.getNickName())
                .build();

        chatRoomRepository.save(room);
    }
}
