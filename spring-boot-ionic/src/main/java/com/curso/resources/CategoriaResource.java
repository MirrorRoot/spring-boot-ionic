package com.curso.resources;

import java.net.URI;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import static java.util.stream.Collectors.toList;

import com.curso.domain.Categoria;
import com.curso.dto.CategoriaDTO;
import com.curso.services.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
 
private CategoriaService categoriaService;	

public CategoriaResource(CategoriaService service) {
	this.categoriaService=service;
}
	
@GetMapping("/{id}")
	public ResponseEntity<Categoria> find(@PathVariable(name="id") Long id) {
    Categoria cat=categoriaService.find(id);  	
	return ResponseEntity.ok().body(cat) ;
		
	}
@PostMapping
public ResponseEntity<Void> insert(@Validated @RequestBody CategoriaDTO catDto){
	Categoria cat = categoriaService.insert(catDto.toCategoria());
	URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cat.getId()).toUri();
	return ResponseEntity.created(uri).build();
	
}

@PutMapping("/{id}")
public ResponseEntity<Void> update(@RequestBody Categoria categoria, @PathVariable Long id){
categoria.setId(id);
this.categoriaService.update(categoria);
 return ResponseEntity.noContent().build();
}
@DeleteMapping("/{id}")
public ResponseEntity<Void> delete(@PathVariable Long id){
this.categoriaService.delete(id);
return ResponseEntity.noContent().build();
	
	
}
@GetMapping
public ResponseEntity<List<CategoriaDTO>> findAll(){
     List<CategoriaDTO> categorias=this.categoriaService.findAll().stream()
    		                       .map(cat->new CategoriaDTO(cat))
    		                       .collect(toList());
	 return ResponseEntity.ok().body(categorias);
	
	
} 
@GetMapping("/page")
public ResponseEntity<Page<CategoriaDTO>> findAll(
		                                  @RequestParam(name="numPage", defaultValue="0") Integer page,
		                                  @RequestParam(name="lines", defaultValue="24") Integer lines,
		                                  @RequestParam(name="direction", defaultValue="ASC") String orderDirection, 
		                                  @RequestParam(name="orderBt", defaultValue="nome") String orderBy ){
	
     Page<CategoriaDTO> categorias=this.categoriaService.findPage(page, lines, orderDirection, orderBy).map(cat->new CategoriaDTO(cat));
	 return ResponseEntity.ok().body(categorias);
	
	
}




}
