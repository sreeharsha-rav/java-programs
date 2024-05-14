package org.ecommerce.orderservice.controller;

import lombok.RequiredArgsConstructor;
import org.ecommerce.orderservice.dto.OrderRequest;
import org.ecommerce.orderservice.model.Order;
import org.ecommerce.orderservice.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order createOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.createOrder(orderRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Order getOrderByID(@PathVariable Long id) {
        return orderService.getOrderByID(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

}
