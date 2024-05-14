package org.ecommerce.productservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ecommerce.productservice.dto.ProductRequest;
import org.ecommerce.productservice.dto.ProductResponse;
import org.ecommerce.productservice.model.Product;
import org.ecommerce.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest) {
        // Create a new product
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .imageUrl(productRequest.imageUrl())
                .build();

        productRepository.save(product);
        log.info("Product created: {}", product);

        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getImageUrl());
    }

    public List<ProductResponse> getAllProducts() {
        // Get all products
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductResponse(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice(),
                        product.getImageUrl()))
                .collect(Collectors.toList());
    }

}
