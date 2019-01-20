 package com.curso.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.curso.domain.Categoria;
import com.curso.repositories.CategoriaRepository;
import com.curso.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {
	
  private CategoriaRepository catRep;
  
  public CategoriaService(CategoriaRepository repo) {
	this.catRep=repo;
}
	
 public Categoria buscar(Long id) {
	 
	 Optional<Categoria> obj = catRep.findById(id);
	 return obj.orElseThrow(() -> new ObjectNotFoundException(
	 "Objeto não encontrado! Id: " + id + ", recurso: "  + Categoria.class.getSimpleName()));
 } 
 public Categoria insert(Categoria cat) {
	 return this.catRep.save(cat);
	 
 }
  
	
}
