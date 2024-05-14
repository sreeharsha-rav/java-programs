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

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price", columnDefinition = "DECIMAL(10,2)") // Limit to 10 digits and 2 decimal points
    private double price;

    @Column(name = "order_date", columnDefinition = "TIMESTAMP")
    private Date orderDate;

}
