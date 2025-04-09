package org.example.mispis_kp.repositories;

import org.example.mispis_kp.models.Certification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificationRepository extends JpaRepository<Certification, Long> {
    Certification findByOrderId(Long orderId);
}
