package com.JTpayment.project.domain.chat.repository;

import com.JTpayment.project.domain.chat.entity.Message;
import com.JTpayment.project.domain.chat.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findByRoom(Room room);
}
