package org.ecommerce.inventoryservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI productServiceAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Inventory Service API for E-commerce Application")
                        .description("Inventory Service checks the availability of products quantity in E-commerce Application")
                        .version("v1.0")
                        .license(new License().name("Apache 2.0")));
    }

}
