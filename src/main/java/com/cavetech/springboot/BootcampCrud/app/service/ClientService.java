package com.cavetech.springboot.BootcampCrud.app.service;

import com.cavetech.springboot.BootcampCrud.app.domain.Client;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService {
	
	
	Mono<Client> save(Client client);

	Mono<Client> update(String id, Client client);

	Flux<Client> findAll();

	Mono<Client> findById(String id);

	Mono<Void> deletexId(String id);

	Mono<Void> delete(Client cliente);

}
