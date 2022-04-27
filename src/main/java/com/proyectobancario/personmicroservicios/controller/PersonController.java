package com.proyectobancario.personmicroservicios.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectobancario.personmicroservicios.util.Constants;
import com.proyectobancario.personmicroservicios.util.Shared;

import com.proyectobancario.personmicroservicios.model.Person;
import com.proyectobancario.personmicroservicios.service.IPersonService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class PersonController  extends Shared{
    
    @Autowired
    IPersonService service;

    @GetMapping("/getCustomer")   
    public Mono<ResponseEntity<Flux<Person>>> getCustomer(){
       return Mono.just(ResponseEntity.ok()  
    		   .contentType(MediaType.APPLICATION_JSON)
    		   .body(service.findAll()));
    		    
    		   
   }
    
    @GetMapping()   
    public Mono<ResponseEntity<Flux<Person>>> getAllActives(){
       return  Mono.just(ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(service.findAllByRegistrationStatus(Constants.ESTADO_VIGENTE))
				);
    		   
   }
    

    @GetMapping("/getCustomerByTypeCustomer/{typeDocument}")
    public Flux<Person> getCustomerByTypeCustomer(@PathVariable("typeDocument") String typeDocument){
        return 	service.findPersonByIdTypeDocument(typeDocument);
    }

    @PostMapping("/postCustomer")
    Mono<ResponseEntity<Person>> postCustomer(@RequestBody Person person){
    	person.setRegistrationStatus(Constants.ESTADO_VIGENTE);
		person.setAudit(getBeanCreationParameters());
        return service.save(person)
        		.map(p-> ResponseEntity
    					.created(URI.create(Constants.URL_PERSON.concat(p.getId())))
    					.contentType(MediaType.APPLICATION_JSON)
    					.body(p));
        }

   
    @PutMapping("/update/{id}")
   public Mono<ResponseEntity<Person>> updCustomer(@RequestBody Person person, @PathVariable String id){
    	return service.findById(id).flatMap(p -> {
			p.setIdTypePerson(person.getIdTypePerson());
			p.setIdTypeDocument(person.getIdTypeDocument());
			p.setName_BusinessName(person.getName_BusinessName());
			p.setNumDocumentIdentity(person.getNumDocumentIdentity());
			p.setNumRUC(person.getNumRUC());
			p.setEmail(person.getEmail());
			p.setFullAdress(person.getFullAdress());
			p.setAudit(getBeanModificationParameters(p.getAudit()));
			return service.save(p);
		}).map(p -> ResponseEntity.created(URI.create(Constants.URL_PERSON.concat(p.getId())))
				.contentType(MediaType.APPLICATION_JSON)
				.body(p))
				.defaultIfEmpty(ResponseEntity.noContent().build());
    
    }

    @DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<Person>> delete(@PathVariable("id") String id){
    	return service.findById(id).flatMap(p -> {
			p.setRegistrationStatus(Constants.ESTADO_NO_VIGENTE);
			p.setAudit(getBeanModificationParameters(p.getAudit()));
			return service.save(p);
		}).map(p -> ResponseEntity.created(URI.create(Constants.URL_PERSON.concat(p.getId())))
				.contentType(MediaType.APPLICATION_JSON)
				.body(p))
				.defaultIfEmpty(ResponseEntity.noContent().build());
    }
    
}
