package org.app.mealmap.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * This class configures the Swagger API documentation.
 * applicationName: the name of the application.
 * publicApi: the public API group.
 * actuatorApi: the Actuator API group.
 */
@Configuration
public class SwaggerConfig {

    @Value("${spring.application.name}")
    private String applicationName;

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group(applicationName)
                .pathsToMatch("/api/**")
                .build();
    }
}
