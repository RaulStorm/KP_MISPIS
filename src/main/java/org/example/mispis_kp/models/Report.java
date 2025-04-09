package org.example.mispis_kp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    private String reportContent; // Контент отчета

    @ManyToOne
    @JoinColumn(name = "engineer_id", nullable = false)
    private User engineer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public User getEngineer() {
        return engineer;
    }

    public void setEngineer(User engineer) {
        this.engineer = engineer;
    }
// геттеры и сеттеры
}
