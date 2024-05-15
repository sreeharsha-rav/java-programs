package org.ecommerce.orderservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ecommerce.orderservice.dto.InventoryResponse;
import org.ecommerce.orderservice.dto.OrderItemDto;
import org.ecommerce.orderservice.dto.OrderRequest;
import org.ecommerce.orderservice.model.Order;
import org.ecommerce.orderservice.model.OrderItem;
import org.ecommerce.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.ecommerce.orderservice.client.InventoryClient;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
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
                    .map(orderItemDto -> mapToOrderItem(orderItemDto, order))
                    .toList();
            order.setOrderItems(orderItems);    // Set order items

            // Check if all items are in stock
            List<String> skuCodes = orderItems.stream()
                    .map(OrderItem::getSkuCode)
                    .toList();  // Get all sku codes
            InventoryResponse[] inventoryResponses = inventoryClient.isInStock(skuCodes);
            boolean allProductsInStock = Arrays.stream(inventoryResponses)
                    .allMatch(InventoryResponse::getIsInStock);

            // Save order
            if (allProductsInStock) {
                orderRepository.save(order);
                log.info("Order created successfully: {}", order.getOrderNumber());
            } else {
                log.error("Order creation failed. Some products are out of stock.");
            }

        } catch (Exception e) {
            log.error("Error occurred while creating order: {}", e.getMessage());
        }
    }

    private OrderItem mapToOrderItem(OrderItemDto orderItemDto, Order order) {
        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setSkuCode(orderItemDto.getSkuCode());
        orderItem.setPrice(orderItemDto.getPrice());
        orderItem.setQuantity(orderItemDto.getQuantity());

        return orderItem;
    }

}
