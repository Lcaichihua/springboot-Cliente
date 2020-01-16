package com.cavetech.springboot.BootcampCrud.app.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "type_product")
public @Data class TypeClient {

	@Id
	private String id ;
	private String nombre ;
	public TypeClient(String nombre) {
		this.nombre = nombre;
	}
	
}