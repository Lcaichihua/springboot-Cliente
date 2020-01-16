package com.cavetech.springboot.BootcampCrud.app.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cavetech.springboot.BootcampCrud.app.domain.Client;
import com.cavetech.springboot.BootcampCrud.app.repository.ClientRepository;
import com.cavetech.springboot.BootcampCrud.app.service.ClientService;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clienttRepository;

	@Override
	public Mono<Client> save(Client client) {
		return this.clienttRepository.save(client);
	}

	@Override
	public Flux<Client> findAll() {
		return this.clienttRepository.findAll();
	}

	@Override
	public Mono<Client> findById(String id) {
		return this.clienttRepository.findById(id);
	}



	@Override
	public Mono<Void> delete(Client client) {
		 return this.clienttRepository.delete(client);
	}



	@Override
	public Mono<Client> update(String id, Client client) {
		   return this.clienttRepository.findById(id)
	                .flatMap(message1 -> {
	                	client.setId(id);
	                    return save(client);
	                })
	                .switchIfEmpty(Mono.empty());
	}

	@Override
	public Mono<Void> deletexId(String id) {
		return this.clienttRepository.deleteById(id);
	}	



	

}
