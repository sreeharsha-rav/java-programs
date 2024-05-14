package org.ecommerce.productservice.controller;

import lombok.RequiredArgsConstructor;
import org.ecommerce.productservice.dto.ProductResponse;
import org.ecommerce.productservice.model.Product;
import org.ecommerce.productservice.service.ProductService;
import org.springframework.web.bind.annotation.*;
import org.ecommerce.productservice.dto.ProductRequest;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

}
