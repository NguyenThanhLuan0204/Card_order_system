package com.fit.se.CardService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import common.dto.CardDTO;

@EnableDiscoveryClient
@SpringBootApplication
public class CardService {
	public static void main(String[] args) {
		SpringApplication.run(CardService.class, args);
	}

}
