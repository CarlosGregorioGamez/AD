package com.example.ApiGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);

}

	@Bean
	public RouteLocator customRouteLocator (RouteLocatorBuilder builder){
		// adding 2 rotes to first microservice as we need to log request body if method is POST
		return builder.routes()
				.route("usuarios-service", r -> r.path("/usuarios")
						.uri("http://localhost:8502"))
				.route("reservas-service", r -> r.path("/reservas")
						.uri("http://localhost:8501"))
				.build();
	}
}
