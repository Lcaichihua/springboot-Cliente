package com.cavetech.springboot.BootcampCrud.app.service;



import com.cavetech.springboot.BootcampCrud.app.domain.Client;
import com.cavetech.springboot.BootcampCrud.app.domain.TypeClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TypeClientService {
	
	Mono<TypeClient> save(TypeClient typeClient);
	 Mono<TypeClient> update(String id, TypeClient typeClient);
	 
	Mono<Void> delete(TypeClient typeClient);

    Flux<TypeClient> findAll();

    Mono<TypeClient> findById(String id);
    
    Mono<Void> deletexId(String id);
    
}
