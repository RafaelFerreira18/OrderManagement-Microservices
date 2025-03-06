package com.order_service.order_app.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order_service.order_app.models.Order;
import com.order_service.order_app.repositories.OrderRepository;
import com.order_service.order_app.Enums.Status;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public void createOrder(Order order){
        orderRepository.save(order);
    }

    public void updateOrderStatus(UUID orderId, Status status){
        Optional<Order> order = orderRepository.findById(orderId);
        if(order.isPresent()){
            order.get().setStatus(status);
            orderRepository.save(order.get());
        }
    }

    public Order findById(UUID orderId){
        Optional<Order> order = orderRepository.findById(orderId);
        return order.get();
    }

    public Iterable<Order> findAll(){
        return orderRepository.findAll();
    }

    public void deleteOrder(UUID orderId){
        orderRepository.deleteById(orderId);
    }
}
