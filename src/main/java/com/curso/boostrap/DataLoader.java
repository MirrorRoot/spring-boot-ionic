package com.curso.boostrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.curso.domain.Categoria;
import com.curso.repositories.CategoriaRepository;

import lombok.extern.slf4j.Slf4j;
@Configuration
public class DataLoader  {
	
    	
    private CategoriaRepository catRep;
	public DataLoader(CategoriaRepository repo) {
		// TODO Auto-generated constructor stub
		this.catRep=repo;
	}
	
	@Bean
	CommandLineRunner initTableCategoria() {
		
		return args->{
		 this.catRep.save(new Categoria(1l, "Informatica"));
		 this.catRep.save(new Categoria(2l, "Estritorio"));
		};
	}
	
}
