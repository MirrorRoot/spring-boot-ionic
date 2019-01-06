package com.curso.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.domain.Categoria;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
    
	@GetMapping
	public List<Categoria> listar() {
	
	Categoria cat1=new Categoria(1l,"Informatica");
	Categoria cat2=new Categoria(2l,"Escritorio");
	List<Categoria> categorias=new ArrayList<>();
	categorias.add(cat1);
	categorias.add(cat2);
		
	return categorias;
		
	}

}
