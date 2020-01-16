package com.cavetech.springboot.BootcampCrud.app.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cavetech.springboot.BootcampCrud.app.domain.Client;
import com.cavetech.springboot.BootcampCrud.app.domain.TypeClient;
import com.cavetech.springboot.BootcampCrud.app.repository.ClientRepository;
import com.cavetech.springboot.BootcampCrud.app.repository.TypeClientRepository;
import com.cavetech.springboot.BootcampCrud.app.service.TypeClientService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TypeClientServiceImpl implements TypeClientService{

	
	
	@Autowired
	private TypeClientRepository Typerepo;

	@Override
	public Mono<TypeClient> save(TypeClient typeClient) {
		return this.Typerepo.save(typeClient);
	}

	
	


	@Override
	public Flux<TypeClient> findAll() {
		return this.Typerepo.findAll();
	}

	@Override
	public Mono<TypeClient> findById(String id) {
		return this.Typerepo.findById(id);
	}





	@Override
	public Mono<Void> delete(TypeClient typeClient) {
		 return this.Typerepo.delete(typeClient);
	                
	}





	@Override
	public Mono<TypeClient> update(String id, TypeClient typeClient) {

		  return this.Typerepo.findById(id)
	                .flatMap(message1 -> {
	                	typeClient.setId(id);
	                    return save(typeClient);
	                })
	                .switchIfEmpty(Mono.empty())	;
		
	}





	@Override
	public Mono<Void> deletexId(String id) {
		return this.deletexId(id);
	}

	
}
