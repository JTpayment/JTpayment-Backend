package com.JTpayment.project.domain.board.repository;

import com.JTpayment.project.domain.board.entity.Board;
import com.JTpayment.project.domain.board.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByBoard(Board board);
}
