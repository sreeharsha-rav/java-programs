package org.ecommerce.orderservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_number")
    private String orderNumber;

    @Column(name = "sku_code")
    private String skuCode;

    @Column(name = "order_date", columnDefinition = "TIMESTAMP")
    private Date orderDate;

    @Column(name = "price", columnDefinition = "DECIMAL(10,2)")
    private double price;

    @Column(name = "quantity")
    private int quantity;

}
