package com.curso.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Produto implements Serializable {
 @Id @GeneratedValue(strategy=GenerationType.AUTO)
 private Long id;
 private String name;
 private double preco;
 
 @JsonBackReference
 @ManyToMany
 @JoinTable(
 name="PRODUTO_CATEGORIA",
 joinColumns= {@JoinColumn(name="produto_id")},
 inverseJoinColumns= {@JoinColumn(name="categoria_id")}
 )
 private List<Categoria> categorias=new ArrayList<>();

    public Produto() {
		// TODO Auto-generated constructor stub
	}
 
	public Produto(Long id, String name, double preco, List<Categoria> categorias) {
	super();
	this.id = id;
	this.name = name;
	this.preco = preco;
	this.categorias = categorias;
}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public List<Categoria> getCategorias() {
		return categorias;
	}
	
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
   
      
 
 
 
 
}
