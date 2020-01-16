package com.cavetech.springboot.BootcampCrud.app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import com.cavetech.springboot.BootcampCrud.app.domain.Client;
import com.cavetech.springboot.BootcampCrud.app.domain.TypeClient;
import com.cavetech.springboot.BootcampCrud.app.repository.ClientRepository;
import com.cavetech.springboot.BootcampCrud.app.repository.TypeClientRepository;

import reactor.core.publisher.Flux;






@EnableReactiveMongoRepositories
@SpringBootApplication
public class SpringbootClienteApplication implements CommandLineRunner{
	
	@Autowired
	private ClientRepository clienttRepo;

	@Autowired
	private TypeClientRepository typeClientRepo;



		
	@Autowired
	private ReactiveMongoTemplate template;


	public static void main(String[] args) {
		SpringApplication.run(SpringbootClienteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		template.dropCollection(Client.class).subscribe();
		template.dropCollection(TypeClient.class).subscribe();
		Client prod1 = new Client(); 
		Client prod2 = new Client();
		
		TypeClient type1 = new TypeClient();
		type1.setNombre("Personal");
		
		
		TypeClient type2 = new TypeClient();
		type2.setNombre("Empresarial");
		
		Flux.just(type1, type2)
		.flatMap(tipP -> typeClientRepo.save(tipP))
		.thenMany(
				Flux.just(new Client("47607058","Larry","Caichihua",true ,  type1),
						  new Client("24678905","Jordy","Alarcon",false ,  type2)
				
					)	
				).flatMap(pro -> clienttRepo.save(pro))
		.subscribe(res -> System.out.println("Producto".concat(res.toString().concat(" " + "Registrado"))));
		
	}

}
