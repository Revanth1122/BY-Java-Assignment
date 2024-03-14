package com.blueyonder.ecomm_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import  org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;



@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(info = @Info(title = "Ecomm service api", description = "Documentation ecomm service API v1.0"))
public class EcommServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommServiceApplication.class, args);
	}

}
