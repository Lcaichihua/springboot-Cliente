package com.cavetech.springboot.BootcampCrud.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cavetech.springboot.BootcampCrud.app.domain.TypeClient;
import com.cavetech.springboot.BootcampCrud.app.service.TypeClientService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("typeClient")
@RestController
public class TypeClientController {
	@Autowired
    private TypeClientService clientService;
	
	@PostMapping("/list")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<TypeClient> save(@RequestBody @Valid TypeClient typeclient) {
        return this.clientService.save(typeclient);
    }
	@GetMapping(value = "/list")
	private Flux<TypeClient> findAll(){
		
		return this.clientService.findAll();
	}
	
	 @PutMapping("/list/{id}")
	    private Mono<ResponseEntity<TypeClient>> update(@PathVariable("id") String id, @RequestBody TypeClient typeclient) {
	        return this.clientService.update(id, typeclient)
	                .flatMap(clientuct1 -> Mono.just(ResponseEntity.ok(clientuct1)))
	                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

	    }
	 
	 @GetMapping( "/list/{id}")
	 private Mono<TypeClient> findTypeClient(@PathVariable String id){
		 
		 return this.clientService.findById(id);
	 }
}
