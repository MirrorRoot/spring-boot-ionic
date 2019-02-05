 package com.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.curso.domain.Categoria;
import com.curso.repositories.CategoriaRepository;
import com.curso.services.exception.DataIntegrityException;
import com.curso.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {
	
  private CategoriaRepository catRep;
  
  public CategoriaService(CategoriaRepository repo) {
	this.catRep=repo;
}
	
 public Categoria find(Long id) {
	 
	 Optional<Categoria> obj = catRep.findById(id);
	 return obj.orElseThrow(() -> new ObjectNotFoundException(
	 "Objeto não encontrado! Id: " + id + ", recurso: "  + Categoria.class.getSimpleName()));
 } 
 public Categoria insert(Categoria cat) {
	 return this.catRep.save(cat);
	 
 }

public void update(Categoria categoria) {
	this.find(categoria.getId());
	this.catRep.save(categoria);
	
}

public void delete(Long id) {
	find(id);
	try {
	this.catRep.deleteById(id);
	}
	catch(DataIntegrityViolationException ex) {
		throw new DataIntegrityException("Não é possível deletar uma categoria que tem produtos");
	}
}

public List<Categoria> findAll(){

	return this.catRep.findAll();
	
	
	
}

public Page<Categoria> findPage(Integer page,Integer lines,String orderDirection, String orderBy ){
	
 PageRequest pagReq= PageRequest.of(page, lines, Direction.valueOf(orderDirection), orderBy);
 return this.catRep.findAll(pagReq);

}

  
	
}
