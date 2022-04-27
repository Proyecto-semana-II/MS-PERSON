package com.proyectobancario.personmicroservicios.service;

import com.proyectobancario.personmicroservicios.model.Person;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPersonService {
    Flux<Person> findAll();
    Mono<Person> findById(String id);
    Flux<Person> findPersonByIdTypeDocument(String IdTypeDocument);
    Flux<Person> findAllByRegistrationStatus(String registrationStatus);
    Mono<Person> save(Person person);
    Mono<Person> update(Person person);
    void delete(String id);
    
}
