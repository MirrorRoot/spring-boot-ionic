package com.curso.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.domain.Pedido;
import com.curso.services.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoResource {
 
private PedidoService PedidoService;	

public PedidoResource(PedidoService service) {
	this.PedidoService=service;
}
	
@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable(name="id") Long id) {
    Pedido ped=PedidoService.buscar(id);  	
	return ResponseEntity.ok().body(ped) ;
		
	}

}
