package org.example.mispis_kp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "deliveries")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deliveryDetails;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeliveryDetails() {
        return deliveryDetails;
    }

    public void setDeliveryDetails(String deliveryDetails) {
        this.deliveryDetails = deliveryDetails;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
