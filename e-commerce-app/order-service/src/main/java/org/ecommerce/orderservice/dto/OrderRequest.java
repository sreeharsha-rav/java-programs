package org.ecommerce.orderservice.dto;

public record OrderRequest(
        String skuCode,
        double price,
        int quantity) {
}
