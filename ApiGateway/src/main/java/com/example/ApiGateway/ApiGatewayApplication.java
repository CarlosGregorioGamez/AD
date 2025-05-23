package com.example.ApiGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
		@Bean
		public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
			// adding 2 rotes to first microservice as we need to log request body if method is POST
			return builder.routes()
					.route("primer-microservicio",r -> r.path("/primer")
							.and().method("POST")
							.and().readBody(Student.class, s -> true).filters(f -> f.filters(requestFilter, authFilter))
							.uri("http://localhost:8081"))
					.route("primer-microservicio",r -> r.path("/primer")
							.and().method("GET").filters(f-> f.filters(authFilter))
							.uri("http://localhost:8081"))
					.route("segundo-microservicio",r -> r.path("/segundo")
							.and().method("POST")
							.and().readBody(Company.class, s -> true).filters(f -> f.filters(requestFilter, authFilter))
							.uri("http://localhost:8082"))
					.route("servidor-autenticacion",r -> r.path("/login")
							.uri("http://localhost:8088"))
					.build();
		}
	}

}
