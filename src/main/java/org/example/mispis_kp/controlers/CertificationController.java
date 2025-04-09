package org.example.mispis_kp.controlers;

import org.example.mispis_kp.models.Certification;
import org.example.mispis_kp.service.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/certifications")
public class CertificationController {

    @Autowired
    private CertificationService certificationService;

    // Сертификация продукции
    @PostMapping
    public Certification certifyProduct(@RequestBody Certification certification) {
        return certificationService.certifyProduct(certification);
    }

    // Получение сертификации по ID
    @GetMapping("/{id}")
    public Certification getCertification(@PathVariable Long id) {
        return certificationService.getCertification(id);
    }

    // Обновление статуса сертификации
    @PutMapping("/{id}")
    public Certification updateCertificationStatus(@PathVariable Long id, @RequestBody String status) {
        return certificationService.updateCertificationStatus(id, status);
    }
}
