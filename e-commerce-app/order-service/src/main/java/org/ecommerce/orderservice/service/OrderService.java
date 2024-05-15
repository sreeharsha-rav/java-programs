package org.ecommerce.orderservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ecommerce.orderservice.dto.OrderItemDto;
import org.ecommerce.orderservice.dto.OrderRequest;
import org.ecommerce.orderservice.dto.OrderResponse;
import org.ecommerce.orderservice.model.Order;
import org.ecommerce.orderservice.model.OrderItem;
import org.ecommerce.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.ecommerce.orderservice.client.InventoryClient;

import java.util.Date;
import java.util.Optional;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;

    private final InventoryClient inventoryClient;

    public void placeOrder(OrderRequest orderRequest) {
        try {
            // Create new order
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString()); // Random order number
            order.setOrderDate(new Date()); // Current date

            // Map Order Request to OrderItems
            List<OrderItem> orderItems = orderRequest.getOrderItems()
                    .stream()
                    .map(this::mapToOrderItem)
                    .toList();

            order.setOrderItems(orderItems);    // Set order items

            // Save order
            Order savedOrder = orderRepository.save(order);
            log.info("Order created successfully: {}", savedOrder);

        } catch (Exception e) {
            log.error("Error occurred while creating order: {}", e.getMessage());
        }
    }

    private OrderItem mapToOrderItem(OrderItemDto orderItemDto) {
        OrderItem orderItem = new OrderItem();
        orderItem.setSkuCode(orderItemDto.getSkuCode());
        orderItem.setPrice(orderItemDto.getPrice());
        orderItem.setQuantity(orderItemDto.getQuantity());

        return orderItem;
    }

}
