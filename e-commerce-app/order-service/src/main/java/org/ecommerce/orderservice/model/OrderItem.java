package org.ecommerce.orderservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "order_items")
public class OrderItem {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @JsonBackReference
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "order_id")
        private Order order;

        @Column(name = "product_id")
        private Long productId;

        @Column(name = "quantity")
        private int quantity;

        @Column(name = "price", columnDefinition = "DECIMAL(10,2)")
        private double price;

}
