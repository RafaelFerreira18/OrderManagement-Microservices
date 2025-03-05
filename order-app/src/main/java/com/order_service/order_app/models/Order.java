package com.order_service.order_app.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

import com.order_service.order_app.Enums.Status;

@Entity
@Table(name = "tab_order")
public class Order {
    private @Setter @Getter UUID id;
    private @Setter @Getter String customerName;
    private @Setter @Getter String productName;
    private @Setter @Getter int quantity;
    private @Setter @Getter Status status;
}
