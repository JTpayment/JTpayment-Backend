package com.JTpayment.project.domain.report.entity;

import com.JTpayment.project.domain.auth.entity.Member;
import com.JTpayment.project.domain.report.entity.enums.Type;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Member author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reported_id")
    private Member reportedMember;

    @Column(nullable = false)
    private LocalDate createDate;

    @Enumerated(EnumType.STRING)
    private Type type;
}
