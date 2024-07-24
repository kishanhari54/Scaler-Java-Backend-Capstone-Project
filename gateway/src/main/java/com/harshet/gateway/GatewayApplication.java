package com.harshet.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				//.route("auth-service", r -> r.path("/auth/**").uri("lb://auth-service"))
				.route("user-service", r -> r.path("/profiles/**").uri("lb://UserProfile"))
				.route("post-service", r -> r.path("/posts/**").uri("lb://PostService"))
				.route("comment-service", r -> r.path("/comments/**").uri("lb://comment"))
				.build();
	}

}
