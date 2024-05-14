package org.ecommerce.orderservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ecommerce.orderservice.dto.OrderRequest;
import org.ecommerce.orderservice.model.Order;
import org.ecommerce.orderservice.model.OrderItem;
import org.ecommerce.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;

    public Order createOrder(OrderRequest orderRequest) {
        try {
            Order newOrder = new Order();   // Create a new order

            // Map order items
            List<OrderItem> orderItems = orderRequest.getOrderItems().stream()
                    .map(orderItemRequest -> OrderItem.builder()
                            .order(newOrder)
                            .productId(orderItemRequest.getProductId())
                            .quantity(orderItemRequest.getQuantity())
                            .price(orderItemRequest.getPrice())
                            .build())
                    .collect(Collectors.toList());

            // Set order properties
            newOrder.setOrderItems(orderItems);
            newOrder.setOrderDate(new Date());
            newOrder.setTotalAmount(orderItems.stream().mapToDouble(OrderItem::getPrice).sum());

            // Save the order
            Order savedOrder = orderRepository.save(newOrder);
            log.info("Order created successfully: {}", savedOrder.getId());

            // Return the order response
            return savedOrder;

        } catch (Exception e) {
            log.error("Error occurred while creating order: {}", e.getMessage());
            return null;
        }
    }

    public Order getOrderByID(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public void deleteOrder(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()) {
            orderRepository.delete(order.get());
            log.info("Order deleted successfully: {}", order.get());
        } else {
            log.error("Order not found: {}", id);
        }
    }

}
