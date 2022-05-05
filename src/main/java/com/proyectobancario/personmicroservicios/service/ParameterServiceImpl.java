package com.proyectobancario.personmicroservicios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.proyectobancario.personmicroservicios.model.dto.Parameter;

import reactor.core.publisher.Flux;

@Service
public class ParameterServiceImpl  {

	/*@Autowired
	private WebClient client;

	@Override
	public Flux<Parameter> findAllActives() {
		return client.get()
				.accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToFlux(Parameter.class);
	}*/

}
