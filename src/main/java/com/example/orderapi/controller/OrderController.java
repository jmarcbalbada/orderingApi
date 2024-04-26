package com.example.orderapi.controller;

import com.example.orderapi.entity.Order;
import com.example.orderapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        System.out.println("order = " + order);
        return orderService.createOrder(order);
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrder(@PathVariable int orderId) {
        orderService.deleteOrder(orderId);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllOrders() {
        Iterable<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
//        return ResponseEntity.ok("gwapo ko");
    }


//    @GetMapping
//    @GetMapping
//    public Iterable<Order> getAllOrders() {
//        return orderService.getAllOrders();
//    }
}
