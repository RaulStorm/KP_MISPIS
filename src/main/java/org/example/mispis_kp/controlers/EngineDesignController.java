package org.example.mispis_kp.controlers;

import org.example.mispis_kp.models.EngineDesign;
import org.example.mispis_kp.service.EngineDesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/engines")
public class EngineDesignController {

    @Autowired
    private EngineDesignService engineDesignService;

    // Разработка новой модели двигателя
    @PostMapping
    public EngineDesign developEngineModel(@RequestBody EngineDesign engineDesign) {
        return engineDesignService.developEngineModel(engineDesign);
    }

    // Получение модели двигателя по ID
    @GetMapping("/{id}")
    public EngineDesign getEngineModel(@PathVariable Long id) {
        return engineDesignService.getEngineModel(id);
    }
}
