package com.proyectobancario.personmicroservicios.service;

import com.proyectobancario.personmicroservicios.model.dto.Parameter;

public interface IKafkaSenderService {
	//public void send(String message);
	public void sendMessage(String topico, Parameter parameter);
}
