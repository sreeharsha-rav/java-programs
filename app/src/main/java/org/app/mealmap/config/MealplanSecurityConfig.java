package org.app.mealmap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
@Configuration
public class MealplanSecurityConfig {

        @Bean
        public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
            return http
                    .authorizeExchange(exchanges -> exchanges
                            .pathMatchers("/api/**").permitAll()
                            .pathMatchers("/swagger-ui/**").permitAll()
                            .pathMatchers("/v3/api-docs/**").permitAll()
                            .anyExchange().authenticated())
                    .formLogin(formLogin -> formLogin.disable())
                    .csrf(csrf -> csrf.disable())
                    .build();
        }
}
