package com.curso.resources;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
@PostMapping
public ResponseEntity<Void> insert(@RequestBody Categoria categoria){
	Categoria cat = categoriaService.insert(categoria);
	URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cat.getId()).toUri();
	 return ResponseEntity.created(uri).build();
	
}

}
