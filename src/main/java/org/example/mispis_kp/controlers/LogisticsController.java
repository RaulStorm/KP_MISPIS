package org.example.mispis_kp.controlers;

import org.example.mispis_kp.models.Delivery;
import org.example.mispis_kp.service.LogisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deliveries")
public class LogisticsController {

    @Autowired
    private LogisticsService logisticsService;

    // Организация доставки
    @PostMapping
    public Delivery organizeDelivery(@RequestBody Delivery delivery) {
        return logisticsService.organizeDelivery(delivery);
    }

    // Получение информации о доставке
    @GetMapping("/{id}")
    public Delivery getDelivery(@PathVariable Long id) {
        return logisticsService.getDelivery(id);
    }
}
