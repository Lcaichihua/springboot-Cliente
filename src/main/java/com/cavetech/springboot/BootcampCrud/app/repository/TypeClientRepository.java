package com.cavetech.springboot.BootcampCrud.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.cavetech.springboot.BootcampCrud.app.domain.Client;
import com.cavetech.springboot.BootcampCrud.app.domain.TypeClient;

public interface TypeClientRepository extends ReactiveMongoRepository<TypeClient, String>{
	
	

}
