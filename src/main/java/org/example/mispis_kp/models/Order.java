package org.example.mispis_kp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "orders")  // Переименовываем таблицу с "order" на "orders"
public class Order {

    // Геттеры и сеттеры
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String technicalSpecification;
    private String status;
    private Long customerId;
    private Long salesManagerId;


    public void setCustomer(User customer) {
    }

    public void setSalesManager(User manager) {
    }
}