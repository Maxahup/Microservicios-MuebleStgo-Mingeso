package com.example.marca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient

public class MarcaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarcaApplication.class, args);
	}

}
