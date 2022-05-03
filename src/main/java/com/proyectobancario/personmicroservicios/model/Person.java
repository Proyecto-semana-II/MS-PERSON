package com.proyectobancario.personmicroservicios.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.proyectobancario.personmicroservicios.bean.AuditBean;
import lombok.Data;

@Data
@Document
public class Person{
    @Id
    private String id;
    private String idTypePerson;
    private String idTypeDocument;
    private String name_BusinessName;
    private String numDocumentIdentity;
    private String numRUC;
    private String fullAdress;
    private String email;
    private String registrationStatus;
	private AuditBean audit;
}