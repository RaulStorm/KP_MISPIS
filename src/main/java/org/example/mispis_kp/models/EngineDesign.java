package org.example.mispis_kp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "engine_designs")
public class EngineDesign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    private String description; // Описание модели

    @ManyToOne
    @JoinColumn(name = "engineer_id", nullable = false)
    private User engineer;

    // геттеры и сеттеры

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getEngineer() {
        return engineer;
    }

    public void setEngineer(User engineer) {
        this.engineer = engineer;
    }
}
