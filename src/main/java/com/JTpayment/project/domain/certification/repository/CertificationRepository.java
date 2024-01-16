package com.JTpayment.project.domain.certification.repository;

import com.JTpayment.project.domain.certification.entity.Certification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificationRepository extends JpaRepository<Certification, Long> {
}
