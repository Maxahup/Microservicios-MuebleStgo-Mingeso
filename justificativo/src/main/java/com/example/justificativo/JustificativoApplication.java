package com.example.justificativo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class JustificativoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JustificativoApplication.class, args);
	}

}
