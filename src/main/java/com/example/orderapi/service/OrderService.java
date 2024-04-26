package com.example.orderapi.service;
import com.example.orderapi.entity.Order;
import com.example.orderapi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order editOrder(int orderId, Order orderDetails) {
        Optional<Order> existingOrder = orderRepository.findById(orderId);
        if (existingOrder.isPresent()) {
            // Update specific fields based on orderDetails (implement your logic here)
            // ...
            return orderRepository.save(existingOrder.get());
        } else {
            throw new RuntimeException("Order with ID " + orderId + " not found");
        }
    }

    public void deleteOrder(int orderId) {
        orderRepository.deleteById(orderId);
    }

    public Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }

//    public Iterable<Order> getAllOrders() {
//        Iterable<Order> orders = orderRepository.findAll();
//        // Iterate through orders and initialize related entities if needed (e.g., using JPA fetch methods)
//        return orders;
//    }

}
