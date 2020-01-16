package com.cavetech.springboot.BootcampCrud.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.cavetech.springboot.BootcampCrud.app.domain.Client;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



public interface ClientRepository extends ReactiveMongoRepository<Client, String>{

	
		
}
