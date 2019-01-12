package com.curso.boostrap;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.curso.domain.Categoria;
import com.curso.domain.Cidade;
import com.curso.domain.Estado;
import com.curso.domain.Produto;
import com.curso.repositories.CategoriaRepository;
import com.curso.repositories.CidadeRepository;
import com.curso.repositories.EstadoRepository;
import com.curso.repositories.ProdutoRepository;
@Profile("dev")
@Configuration
public class DataLoader  {
	
    	
    private CategoriaRepository catRep;
    private ProdutoRepository prodRep;
    private EstadoRepository estRep;
    private CidadeRepository cidRep;
	public DataLoader(CategoriaRepository repo, ProdutoRepository repop, CidadeRepository cidr, EstadoRepository estr) {
		// TODO Auto-generated constructor stub
		this.catRep=repo;
		this.prodRep=repop;
		this.estRep=estr;
		this.cidRep=cidr;
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
		Estado est1=new Estado(null,"Minas Gerais", "MG");
		Estado est2=new Estado(null,"Sao Paulo", "SP");
		Cidade cid1=new Cidade(null,"Patos de Minas", est1);
		Cidade cid2=new Cidade(null,"Uberlandia", est1);
		Cidade cid3=new Cidade(null,"Patrocinio", est1);
		Cidade cid4=new Cidade(null,"Campinas", est2);
		Cidade cid5=new Cidade(null,"Mogi", est2);
		est1.getCidades().add(cid1);
		est1.getCidades().add(cid2);
		est1.getCidades().add(cid3);
		est2.getCidades().add(cid4);
		est2.getCidades().add(cid5);
		return args->{
		this.catRep.saveAll(Arrays.asList(cat1,cat2));
		this.prodRep.saveAll(Arrays.asList(p1,p2,p3));
		this.estRep.saveAll(Arrays.asList(est1,est2));
		this.cidRep.saveAll(Arrays.asList(cid1,cid2,cid3,cid4,cid5));
		};
	}
	
}
