 package com.curso.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.curso.domain.Cliente;
import com.curso.repositories.ClienteRepository;
import com.curso.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {
	
  private ClienteRepository catRep;
  
  public ClienteService(ClienteRepository repo) {
	this.catRep=repo;
}
	
 public Cliente buscar(Long id) {
	 
	 Optional<Cliente> obj = catRep.findById(id);
	 return obj.orElseThrow(() -> new ObjectNotFoundException(
	 "Objeto não encontrado! Id: " + id + ", recurso: "  + Cliente.class.getSimpleName()));
 } 
  
	
}
