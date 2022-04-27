package com.proyectobancario.personmicroservicios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.proyectobancario.personmicroservicios.model.Person;
import com.proyectobancario.personmicroservicios.repository.IPersonRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonServiceImpl implements IPersonService{

    @Autowired
    IPersonRepository repository;

    @Override
    public Flux<Person> findAll() {        
        return repository.findAll();
    }

    @Override
	public Mono<Person> findById(String id) {
		return repository.findById(id);
	}
    
    @Override
    public Mono<Person> save(Person person) {
        return repository.save(person);
    }
   
    @Override
    public Flux<Person> findPersonByIdTypeDocument(String idTypeDocument) {
        
        return repository.findPersonByIdTypeDocument(idTypeDocument);
    }

    @Override
    public Flux<Person> findAllByRegistrationStatus(String registrationStatus)
    {
    	return repository.findAllByRegistrationStatus(registrationStatus);
    }
    @Override
    public Mono<Person> update(Person person) {
       
        return repository.save(person);
    }

    @Override
      public void delete(String id) {
       
         repository.deleteById(id).subscribe();
    }
    
}