package com.proyectobancario.personmicroservicios.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.proyectobancario.personmicroservicios.model.Person;

import reactor.core.publisher.Flux;

@Repository
public interface IPersonRepository  extends ReactiveMongoRepository<Person,String>{
    Flux<Person>  findPersonByIdTypeDocument(String IdTypeDocument);
    Flux<Person> findAllByRegistrationStatus(String registrationStatus);
}
