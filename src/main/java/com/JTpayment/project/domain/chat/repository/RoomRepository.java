package com.JTpayment.project.domain.chat.repository;

import com.JTpayment.project.domain.chat.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {

    Optional<Room> findByRoomId(String roomId);

    List<Room> findByHostOrGuest(String host, String guest);
}
