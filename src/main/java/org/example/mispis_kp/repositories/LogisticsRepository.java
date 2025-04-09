package org.example.mispis_kp.repositories;

import org.example.mispis_kp.models.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogisticsRepository extends JpaRepository<Delivery, Long> {
}
