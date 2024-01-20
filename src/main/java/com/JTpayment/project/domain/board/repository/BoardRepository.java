package com.JTpayment.project.domain.board.repository;

import com.JTpayment.project.domain.auth.entity.Member;
import com.JTpayment.project.domain.board.entity.Board;
import com.JTpayment.project.domain.certification.entity.Certification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findByAuthor(Member member);

    List<Board> findByCertification(Certification certification);
}
