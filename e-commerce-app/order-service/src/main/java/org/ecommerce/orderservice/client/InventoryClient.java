package org.ecommerce.orderservice.client;

import lombok.RequiredArgsConstructor;
import org.ecommerce.orderservice.dto.InventoryResponse;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

/*
 * This class is used to make requests to the inventory-service using the WebClient.
 * isInstock: Used to check if the products are in stock.
 */
@RequiredArgsConstructor
public class InventoryClient {

    private final WebClient webClient;

    public InventoryResponse[] isInStock(List<String> skuCodes) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("api/inventory")
                        .queryParam("skuCodes", skuCodes)
                        .build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();
    }

}
