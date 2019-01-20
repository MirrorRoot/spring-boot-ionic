package com.curso.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.domain.Categoria;
import com.curso.services.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
 
private CategoriaService categoriaService;	

public CategoriaResource(CategoriaService service) {
	this.categoriaService=service;
}
	
@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable(name="id") Long id) {
    Categoria cat=categoriaService.buscar(id);  	
	return ResponseEntity.ok().body(cat) ;
		
	}

}
