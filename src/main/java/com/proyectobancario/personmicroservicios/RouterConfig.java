package com.proyectobancario.personmicroservicios;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.proyectobancario.personmicroservicios.handler.ParameterHandler;

@Configuration
public class RouterConfig {

	@Bean
	public RouterFunction<ServerResponse> routes(ParameterHandler handler) {
		return RouterFunctions.route(RequestPredicates.GET("/api/parameter"), handler::getAllActives);
	}
}
