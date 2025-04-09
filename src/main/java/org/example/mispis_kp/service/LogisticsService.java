package org.example.mispis_kp.service;

import org.example.mispis_kp.models.Delivery;
import org.example.mispis_kp.repositories.LogisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogisticsService {

    @Autowired
    private LogisticsRepository logisticsRepository;

    // Метод для организации доставки
    public Delivery organizeDelivery(Delivery delivery) {
        return logisticsRepository.save(delivery);
    }

    // Метод для получения информации о доставке по ID
    public Delivery getDelivery(Long id) {
        return logisticsRepository.findById(id).orElseThrow(() -> new RuntimeException("Delivery not found"));
    }
}
