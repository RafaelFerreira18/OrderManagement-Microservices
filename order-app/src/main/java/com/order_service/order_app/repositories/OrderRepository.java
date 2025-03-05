package com.order_service.order_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order_service.order_app.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Long, Order> {
    
}
