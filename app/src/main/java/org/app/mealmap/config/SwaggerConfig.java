package org.app.mealmap.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * This class configures the Swagger API documentation.
 */
@Configuration
public class SwaggerConfig {

    @Bean
    GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("MealMap - V1")
                .pathsToMatch("/api/**")
                .build();
    }
}
