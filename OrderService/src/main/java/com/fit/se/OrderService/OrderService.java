package com.fit.se.OrderService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class OrderService {
	public static void main(String[] args) {
		SpringApplication.run(OrderService.class, args);
	}

}
