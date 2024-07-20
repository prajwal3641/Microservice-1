package com.infosys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class Gateway3Application {

	public static void main(String[] args) {
		SpringApplication.run(Gateway3Application.class, args);
	}
	
	@Bean
	public RouteLocator routerBuilder(RouteLocatorBuilder routeLocatorBuilder) {
		return routeLocatorBuilder.routes()
				.route("Address-MSA",r->r.path("/address-service/**").uri("http://localhost:8081/"))
				.route("Student-MSA",r->r.path("/Student-service/**").uri("http://localhost:8080/")).build();
		
	}

}
