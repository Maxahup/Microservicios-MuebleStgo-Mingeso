package com.example.autorizacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AutorizacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutorizacionApplication.class, args);
	}

}
