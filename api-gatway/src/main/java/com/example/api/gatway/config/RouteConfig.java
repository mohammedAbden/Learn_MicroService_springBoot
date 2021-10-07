package com.example.api.gatway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("EMPLOYEE-SERVICE", r -> r.path("/EMPLOYEE-SERVICE/**")
                        .filters(f -> f.rewritePath("/EMPLOYEE-SERVICE(?<segment>/?.*)", "$\\{segment}"))
                        .uri("lb://EMPLOYEE-SERVICE"))
                .build();

    }

}
