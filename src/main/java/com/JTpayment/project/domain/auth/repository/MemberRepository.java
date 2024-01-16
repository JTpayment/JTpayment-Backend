package com.JTpayment.project.domain.auth.repository;

import com.JTpayment.project.domain.auth.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {
    boolean existsByLoginId(String loginId);
    boolean existsByNickName(String nickName);
    boolean existsByEmail(String email);

    Optional<Member> findMemberByLoginId(String loginId);
}
