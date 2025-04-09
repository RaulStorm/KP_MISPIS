package org.example.mispis_kp.repositories;

import org.example.mispis_kp.models.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
    Report findByOrderId(Long orderId);
}
