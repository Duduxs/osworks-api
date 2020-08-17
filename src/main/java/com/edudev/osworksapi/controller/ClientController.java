package com.edudev.osworksapi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edudev.osworksapi.model.Client;

@RestController
@RequestMapping(value="clients")
public class ClientController {

	@GetMapping
	public ResponseEntity<List<Client>> list(){
		Client c1 = new Client(1L, "Eduardo", "duduxss3@gmail.com", "(81) 98739-5261");
		Client c2 = new Client(2L, "Ednaldo Pereira", "Ed23@bol.com", "(81) 8658-7263");
		
		return ResponseEntity.ok().body(Arrays.asList(c1,c2));
	}
}
