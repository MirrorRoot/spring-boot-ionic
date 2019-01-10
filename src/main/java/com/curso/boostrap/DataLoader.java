package com.curso.boostrap;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.curso.domain.Categoria;
import com.curso.domain.Produto;
import com.curso.repositories.CategoriaRepository;
import com.curso.repositories.ProdutoRepository;


import lombok.extern.slf4j.Slf4j;
@Configuration
public class DataLoader  {
	
    	
    private CategoriaRepository catRep;
    private ProdutoRepository prodRep;
	public DataLoader(CategoriaRepository repo, ProdutoRepository repop) {
		// TODO Auto-generated constructor stub
		this.catRep=repo;
		this.prodRep=repop;
	}
	
	@Bean
	CommandLineRunner initTableCategoria() {
		Categoria cat1=new Categoria();
	    Categoria cat2=new Categoria();		
	    cat1.setNome("Informatica");
	    cat2.setNome("Escritorio");
	    Produto p1=new Produto();
	    p1.setName("Computador");
	    p1.setPreco(2000);
	    Produto p2=new Produto();
	    p2.setName("impressora");
	    p2.setPreco(800);
	    Produto p3=new Produto();
	    p3.setName("mouse");
	    p3.setPreco(80);
	    cat1.setProdutos(Arrays.asList(p1,p2,p3));
	    cat2.setProdutos(Arrays.asList(p2));
		p1.getCategorias().add(cat1);
		p2.getCategorias().add(cat2);
		p2.getCategorias().add(cat1);
		p3.getCategorias().add(cat1);
	    return args->{
		this.catRep.saveAll(Arrays.asList(cat1,cat2));
		this.prodRep.saveAll(Arrays.asList(p1,p2,p3));
		};
	}
	
}
