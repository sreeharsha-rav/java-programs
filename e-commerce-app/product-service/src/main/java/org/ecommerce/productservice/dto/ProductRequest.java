package org.ecommerce.productservice.dto;

public record ProductRequest(
        String name,
        String description,
        double price,
        String imageUrl) { }
