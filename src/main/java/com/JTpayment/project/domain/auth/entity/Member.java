package com.JTpayment.project.domain.auth.entity;

import com.JTpayment.project.domain.auth.entity.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String loginId;

    @Column(name = "member_password", nullable = false)
    private String password;

    @Column(name = "member_nickname", nullable = false,unique = true)
    private String nickName;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;
}
