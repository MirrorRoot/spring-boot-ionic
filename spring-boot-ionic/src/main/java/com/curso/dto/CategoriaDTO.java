package com.curso.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.curso.domain.Categoria;

public class CategoriaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	@NotEmpty(message="Preenchimento é obrigatório")
	@Length(min=5,max=80, message="o tamanho deve ser entre 5 e 80 caracteres")
	private String nome;
	public CategoriaDTO() {
		// TODO Auto-generated constructor stub
	}
	public CategoriaDTO(Categoria cat) {
		this.id=cat.getId();
	    this.nome=cat.getNome();			
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Categoria toCategoria() {
	 Categoria  cat=new Categoria();
	 cat.setId(this.id);
	 cat.setNome(this.nome);
	 return cat;
	
		
	}

}
