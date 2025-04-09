package org.example.mispis_kp.repositories;

import org.example.mispis_kp.models.Material;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaterialRepository extends JpaRepository<Material, Long> {
    List<Material> findByOrderId(Long orderId);
}
