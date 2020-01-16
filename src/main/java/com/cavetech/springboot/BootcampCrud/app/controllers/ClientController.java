


package com.cavetech.springboot.BootcampCrud.app.controllers;


import com.cavetech.springboot.BootcampCrud.app.domain.Client;
import com.cavetech.springboot.BootcampCrud.app.service.ClientService;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RequestMapping("client")
@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    
    @PostMapping("/list")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Client> save(@RequestBody @Valid Client client) {
        return this.clientService.save(client);
    }

   
    
    

    @PutMapping("/list/{id}")
    private Mono<ResponseEntity<Client>> update(@PathVariable("id") String id, @RequestBody Client client) {
        return this.clientService.update(id, client)
                .flatMap(clientuct1 -> Mono.just(ResponseEntity.ok(clientuct1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

  
    @GetMapping(value = "/list")
    private Flux<Client> findAll() {
        return this.clientService.findAll();
        
       
    }
    
    @GetMapping(value ="/list/{id}")
    private Mono<Client> findClient(@PathVariable("id") String id) {
    	
  return this.clientService.findById(id);  	
    }
    
    @DeleteMapping(value = "/list")
    private Mono<Void> delete(@PathVariable String id){
    	return  this.clientService.deletexId(id);
    	
    	
    }
    
    

}
