package com.curso.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.domain.Cliente;
import com.curso.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {
 
private ClienteService clienteService;	

public ClienteResource(ClienteService service) {
	this.clienteService=service;
}
	
@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable(name="id") Long id) {
    Cliente cliente=clienteService.buscar(id);  	
	return ResponseEntity.ok().body(cliente) ;
		
	}

}
