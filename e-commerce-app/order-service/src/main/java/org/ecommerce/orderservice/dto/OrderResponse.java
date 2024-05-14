package org.ecommerce.orderservice.dto;

public record OrderResponse(
        Long id,
        String orderNumber,
        String skuCode,
        double price,
        int quantity,
        String orderDate) {
}
