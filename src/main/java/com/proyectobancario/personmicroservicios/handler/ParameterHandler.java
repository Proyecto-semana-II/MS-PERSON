package com.proyectobancario.personmicroservicios.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.proyectobancario.personmicroservicios.model.dto.Parameter;
import com.proyectobancario.personmicroservicios.service.IParamaterService;

import reactor.core.publisher.Mono;

@Component
public class ParameterHandler {

	@Autowired
	IParamaterService service;

	public Mono<ServerResponse> getAllActives(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(service.findAllActives(),
				Parameter.class);
	}
}
