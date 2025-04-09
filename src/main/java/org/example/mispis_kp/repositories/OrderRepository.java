package org.example.mispis_kp.repositories;

import org.example.mispis_kp.models.Order;
import org.example.mispis_kp.models.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    // Получить заказ, назначенный конкретному менеджеру
    Order findAssignedOrder(Long managerId);

    // Получить все заказы, находящиеся в ожидании
    List<Order> findPendingOrders();
    List<Order> findByStatus(OrderStatus status);

}
