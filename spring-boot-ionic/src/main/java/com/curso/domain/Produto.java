package com.curso.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Produto implements Serializable {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id @GeneratedValue(strategy=GenerationType.AUTO)
 private Long id;
 private String name;
 private double preco;
 
 @JsonIgnore
 @ManyToMany
 @JoinTable(
 name="PRODUTO_CATEGORIA",
 joinColumns= {@JoinColumn(name="produto_id")},
 inverseJoinColumns= {@JoinColumn(name="categoria_id")}
 )
 private List<Categoria> categorias=new ArrayList<>();
 @JsonIgnore
 @OneToMany(mappedBy="id.produto")
 private Set<ItemPedido> itens =new HashSet<>();
 
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
@JsonIgnore
public List<Pedido> getPedidos(){
 List<Pedido> pedidos=new ArrayList<>();
 for(ItemPedido itemPedido:itens) {
	pedidos.add(itemPedido.getPedido()); 
	 
	 
 }
 return pedidos;
	
}


public Set<ItemPedido> getItens() {
	return itens;
}


      
 
 
 
 
}
