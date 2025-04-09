package org.example.mispis_kp.service;

import org.example.mispis_kp.models.EngineDesign;
import org.example.mispis_kp.repositories.EngineDesignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EngineDesignService {

    @Autowired
    private EngineDesignRepository engineDesignRepository;

    // Метод для разработки технической модели двигателя
    public EngineDesign developEngineModel(EngineDesign engineDesign) {
        return engineDesignRepository.save(engineDesign);
    }

    // Метод для получения модели двигателя по ID
    public EngineDesign getEngineModel(Long id) {
        return engineDesignRepository.findById(id).orElseThrow(() -> new RuntimeException("Engine model not found"));
    }
}
