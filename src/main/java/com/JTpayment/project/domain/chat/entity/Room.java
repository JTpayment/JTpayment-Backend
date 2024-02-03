package com.JTpayment.project.domain.chat.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Room {

    @Id
    @Column(name = "room_id")
    private String roomId;

    @Column(nullable = false)
    private String host;

    @Column(nullable = false)
    private String guest;

    @Column
    private String lastMessage;

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> messageList;

    public void setLastMessage(String message) {
        this.lastMessage = message;
    }
}
