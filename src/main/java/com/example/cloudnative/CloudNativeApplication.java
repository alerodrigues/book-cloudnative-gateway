package com.example.cloudnative;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CloudNativeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudNativeApplication.class, args);
	}
	
	/*
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
	    return builder.routes()
	        .route(p -> p
	        		.path("/api/v1/books")
	        		.uri("http://localhost:8081"))

	        .route(p -> p
	        		.path("/api/v1/orders")
		            .uri("http://localhost:8082"))

	        .build();
	}	
	*/
	
}
