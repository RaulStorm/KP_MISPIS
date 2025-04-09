package org.example.mispis_kp.service;

import org.example.mispis_kp.models.Material;
import org.example.mispis_kp.repositories.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    // Метод для добавления нового материала
    public Material addMaterial(Material material) {
        return materialRepository.save(material);
    }

    // Метод для получения всех материалов для определенного заказа
    public List<Material> getMaterialsByOrderId(Long orderId) {
        return materialRepository.findByOrderId(orderId);
    }
}
