 package com.curso.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.curso.domain.Categoria;
import com.curso.domain.Pedido;
import com.curso.repositories.PedidoRepository;
import com.curso.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {
	
  private PedidoRepository pedidoRep;
  
  public PedidoService(PedidoRepository repo) {
	this.pedidoRep=repo;
}
	
 public Pedido buscar(Long id) {
	 
	 Optional<Pedido> obj = pedidoRep.findById(id);
	 return obj.orElseThrow(() -> new ObjectNotFoundException(
	 "Objeto não encontrado! Id: " + id + ", recurso: "  + Categoria.class.getSimpleName()));
 } 
  
	
}
