package com.JTpayment.project.domain.chat.presentation.dto.response;

import com.JTpayment.project.domain.chat.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class RoomResponse {

    private String roomId;

    private String host;

    private String lastMessage;

    public static RoomResponse toResponse(Room room) {
        return RoomResponse.builder()
                .roomId(room.getRoomId())
                .host(room.getHost())
                .lastMessage(room.getLastMessage())
                .build();
    }
}
