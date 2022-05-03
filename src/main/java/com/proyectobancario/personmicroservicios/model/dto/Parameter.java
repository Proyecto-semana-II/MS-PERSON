package com.proyectobancario.personmicroservicios.model.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.proyectobancario.personmicroservicios.bean.AuditBean;

import lombok.Data;

@Data
@Document
public class Parameter {

	@Id
	private String idParameter;
	private String name;
	private String abbreviation;
	private String description;
	private String registrationStatus;
	private AuditBean audit;

}