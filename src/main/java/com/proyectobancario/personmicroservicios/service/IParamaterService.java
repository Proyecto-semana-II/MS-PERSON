package com.proyectobancario.personmicroservicios.service;

import com.proyectobancario.personmicroservicios.model.dto.Parameter;

import reactor.core.publisher.Flux;

public interface IParamaterService {

	public Flux<Parameter> findAllActives();
}
