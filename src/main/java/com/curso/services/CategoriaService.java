 package com.curso.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.curso.domain.Categoria;
import com.curso.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
  private CategoriaRepository catRep;
  
  public CategoriaService(CategoriaRepository repo) {
	this.catRep=repo;
}
	
 public Optional<Categoria>buscar(Long id) {
	 
	 return this.catRep.findById(id);
	 
	 
 } 
  
	
}
