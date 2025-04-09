package org.example.mispis_kp.controlers;

import org.example.mispis_kp.models.Material;
import org.example.mispis_kp.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materials")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    // Добавление нового материала
    @PostMapping
    public Material addMaterial(@RequestBody Material material) {
        return materialService.addMaterial(material);
    }

    // Получение всех материалов для заказа
    @GetMapping("/{orderId}")
    public List<Material> getMaterials(@PathVariable Long orderId) {
        return materialService.getMaterialsByOrderId(orderId);
    }
}
