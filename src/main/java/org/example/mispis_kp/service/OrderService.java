package org.example.mispis_kp.service;

import org.example.mispis_kp.models.*;
import org.example.mispis_kp.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final EngineDesignRepository engineDesignRepository;
    private final ReportRepository reportRepository;
    private final CertificationRepository certificationRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository,
                        UserRepository userRepository,
                        EngineDesignRepository engineDesignRepository,
                        ReportRepository reportRepository,
                        CertificationRepository certificationRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.engineDesignRepository = engineDesignRepository;
        this.reportRepository = reportRepository;
        this.certificationRepository = certificationRepository;
    }

    // Менеджер по работе с клиентами видит заказы с статусом NEW или IN_PROGRESS
    public List<Order> getOrdersForManager(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return orderRepository.findByStatus(OrderStatus.NEW);
    }

    // Инженер разрабатывает модель и пишет отчет для заказа
    public Order createEngineDesignAndReport(Long orderId, String modelDescription, String reportContent, Long engineerId) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        User engineer = userRepository.findById(engineerId).orElseThrow();

        EngineDesign engineDesign = new EngineDesign();
        engineDesign.setOrder(order);
        engineDesign.setDescription(modelDescription);
        engineDesign.setEngineer(engineer);
        engineDesignRepository.save(engineDesign);

        Report report = new Report();
        report.setOrder(order);
        report.setReportContent(reportContent);
        report.setEngineer(engineer);
        reportRepository.save(report);

        order.setStatus(OrderStatus.IN_PROGRESS);
        orderRepository.save(order);

        return order;
    }

    // Специалист по сертификации добавляет номер сертификации
    public Order certifyOrder(Long orderId, String certificationNumber, Long certifierId) {
        Order order = orderRepository.findById(orderId).orElseThrow();
        User certifier = userRepository.findById(certifierId).orElseThrow();

        Certification certification = new Certification();
        certification.setOrder(order);
        certification.setCertificationNumber(certificationNumber);
        certification.setCertificationDate(new java.sql.Date(System.currentTimeMillis()));
        certification.setCertifier(certifier);
        certificationRepository.save(certification);

        order.setStatus(OrderStatus.COMPLETED);
        orderRepository.save(order);

        return order;
    }
}