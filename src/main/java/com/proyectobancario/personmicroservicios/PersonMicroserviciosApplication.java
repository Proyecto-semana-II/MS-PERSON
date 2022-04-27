package com.proyectobancario.personmicroservicios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class PersonMicroserviciosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonMicroserviciosApplication.class, args);
	}

}
