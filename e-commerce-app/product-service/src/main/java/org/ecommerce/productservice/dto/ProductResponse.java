package org.ecommerce.productservice.dto;

public record ProductResponse(
        String id,
        String name,
        String description,
        double price,
        String imageUrl) {
}
