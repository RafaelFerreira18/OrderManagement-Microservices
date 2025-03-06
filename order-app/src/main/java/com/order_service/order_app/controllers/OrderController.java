package com.order_service.order_app.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.order_service.order_app.Enums.Status;
import com.order_service.order_app.models.Order;
import com.order_service.order_app.services.OrderService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
        return order;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> searchById(@PathVariable UUID id) {
        Order order = orderService.findById(id);
        return ResponseEntity.ok(order);
    }

    @GetMapping
    public ResponseEntity<Iterable<Order>> searchAll() {
        Iterable<Order> orders = orderService.findAll();
        return ResponseEntity.ok(orders);
    }

    @PutMapping("/{status}")
    public ResponseEntity<Order> updateOrder(@PathVariable UUID id, @RequestBody Status status) {
        orderService.updateOrderStatus(id, status);
        Order order = orderService.findById(id);
        return ResponseEntity.ok(order);
    }
    
    
    

}
