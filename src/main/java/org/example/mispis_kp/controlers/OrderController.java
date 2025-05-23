package org.example.mispis_kp.controlers;

import org.example.mispis_kp.models.Order;
import org.example.mispis_kp.models.OrderStatus;
import org.example.mispis_kp.models.User;
import org.example.mispis_kp.repositories.OrderRepository;
import org.example.mispis_kp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    // Создание заказа
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        // Если передаётся только customer_id — можно подтянуть пользователя
        if (order.getCustomerId() != null ) {
            User customer = userRepository.findById(order.getCustomerId()).orElse(null);
            order.setCustomer(customer);
        }

        order.setStatus(String.valueOf(OrderStatus.NEW)); // Здесь мы присваиваем объект типа OrderStatus
        return orderRepository.save(order);
    }

    // Получение назначенного заказа для менеджера
    @GetMapping("/assigned/{managerId}")
    public Order getAssignedOrder(@PathVariable Long managerId) {
        return orderRepository.findAssignedOrder(managerId);
    }

    // Получение заказов в ожидании
    @GetMapping("/pending")
    public List<Order> getPendingOrders() {
        return orderRepository.findPendingOrders();
    }

    // Назначить заказ менеджеру
    @PostMapping("/assign")
    public Order assignOrder(@RequestParam Long orderId, @RequestParam Long managerId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            User manager = userRepository.findById(managerId).orElse(null);
            order.setSalesManager(manager);
            order.setStatus(String.valueOf(OrderStatus.ASSIGNED)); // Присваиваем статус
            return orderRepository.save(order);
        }
        return null;
    }
}