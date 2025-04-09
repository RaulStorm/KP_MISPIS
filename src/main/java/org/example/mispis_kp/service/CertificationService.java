package org.example.mispis_kp.service;

import org.example.mispis_kp.models.Certification;
import org.example.mispis_kp.repositories.CertificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertificationService {

    @Autowired
    private CertificationRepository certificationRepository;

    // Метод для сертификации продукции
    public Certification certifyProduct(Certification certification) {
        return certificationRepository.save(certification);
    }

    // Метод для получения информации о сертификации по ID
    public Certification getCertification(Long id) {
        return certificationRepository.findById(id).orElseThrow(() -> new RuntimeException("Certification not found"));
    }

    // Метод для обновления статуса сертификации
    public Certification updateCertificationStatus(Long id, String status) {
        Certification certification = certificationRepository.findById(id).orElseThrow(() -> new RuntimeException("Certification not found"));
        certification.setCertificationStatus(status);
        return certificationRepository.save(certification);
    }
}
