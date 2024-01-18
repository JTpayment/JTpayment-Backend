package com.JTpayment.project.domain.board.repository;

import com.JTpayment.project.domain.auth.entity.Member;
import com.JTpayment.project.domain.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByAuthor(Member member);
}
