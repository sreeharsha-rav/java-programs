package org.ecommerce.orderservice.config;

import org.ecommerce.orderservice.client.InventoryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/*
 * This class is used to configure the WebClient bean and InventoryClient bean.
 * WebClient: Used to make HTTP requests to the inventory-service.
 * InventoryClient: Used to make requests to the inventory-service using the WebClient.
 */
@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }

    @Bean
    public InventoryClient inventoryClient(WebClient webClient) {
        return new InventoryClient(webClient);
    }

}
