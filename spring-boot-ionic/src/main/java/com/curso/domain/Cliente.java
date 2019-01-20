package com.curso.domain;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.curso.domain.enums.TipoCliente;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cliente implements Serializable {

private static final long serialVersionUID = 1L;
@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private String nome;
private String cpfOuCnpj;
private String email;
private int tipo;
@ElementCollection
@CollectionTable(name="telefones")
private Set<String> telefone=new HashSet<>();

@JsonIgnore
@OneToMany(mappedBy="cliente")
private List<Pedido> pedidos;


@OneToMany(mappedBy="cliente")
private List<Endereco> enderecos=new ArrayList<>();

public Cliente() {
	// TODO Auto-generated constructor stub
}

public Cliente(Long id, String nome, String cpfOuCnpj, String email, TipoCliente tipo, Set<String> telefones) {
	super();
	this.id = id;
	this.nome = nome;
	this.cpfOuCnpj = cpfOuCnpj;
	this.email = email;
	this.tipo = tipo.getCod();
	this.telefone = telefones;
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

public String getCpfOuCnpj() {
	return cpfOuCnpj;
}

public void setCpfOuCnpj(String cpfOuCnpj) {
	this.cpfOuCnpj = cpfOuCnpj;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public TipoCliente getTipo() {
	return TipoCliente.toTipoCliente(this.tipo);
}


public Set<String> getTelefones() {
	return telefone;
}

public void setTelefones(Set<String> telefones) {
	this.telefone = telefones;
}

public List<Endereco> getEnderecos() {
	return enderecos;
}

public void setEnderecos(List<Endereco> enderecos) {
	this.enderecos = enderecos;
}


public Set<String> getTelefone() {
	return telefone;
}

public void setTelefone(Set<String> telefone) {
	this.telefone = telefone;
}

public List<Pedido> getPedidos() {
	return pedidos;
}

public void setPedidos(List<Pedido> pedidos) {
	this.pedidos = pedidos;
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
	Cliente other = (Cliente) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}


}
