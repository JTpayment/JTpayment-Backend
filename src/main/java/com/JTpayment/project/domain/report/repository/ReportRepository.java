package com.JTpayment.project.domain.report.repository;

import com.JTpayment.project.domain.report.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {

}
