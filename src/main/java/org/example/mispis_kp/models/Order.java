package org.example.mispis_kp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")  // Переименовываем таблицу с "order" на "orders"
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String technicalSpecification;
    private String status;
    private Long customerId;
    private Long salesManagerId;

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTechnicalSpecification() {
        return technicalSpecification;
    }

    public void setTechnicalSpecification(String technicalSpecification) {
        this.technicalSpecification = technicalSpecification;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getSalesManagerId() {
        return salesManagerId;
    }

    public void setSalesManagerId(Long salesManagerId) {
        this.salesManagerId = salesManagerId;
    }



    public void setCustomer(User customer) {
    }

    public void setSalesManager(User manager) {
    }
}
