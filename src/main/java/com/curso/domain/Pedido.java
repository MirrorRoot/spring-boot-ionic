package com.curso.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static java.util.stream.Collectors.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Pedido implements Serializable  {


private static final long serialVersionUID = 1L;

@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
@JsonFormat(pattern="dd/MM/yyyy HH:mm")
@Column(name="data_pedido")
private LocalDateTime instant;

@OneToOne(cascade=CascadeType.ALL,mappedBy="pedido")
private Pagamento pagamento;

@ManyToOne
@JoinColumn(name="cliente_id")
private Cliente cliente;

@OneToOne
@JoinColumn(name="endereco_id")
private Endereco enderecoDeEntrega;

@OneToMany(mappedBy="id.pedido")
private Set<ItemPedido> itens=new HashSet<>();
 public Pedido(Long id, LocalDateTime instant, Cliente cliente, Endereco enderecoDeEntrega) {
	super();
	this.id = id;
	this.instant = instant;
	this.cliente = cliente;
	this.enderecoDeEntrega = enderecoDeEntrega;
}

public Long getId() {
	return id;
}

public Set<ItemPedido> getItens() {
	return itens;
}


public void setId(Long id) {
	this.id = id;
}

public LocalDateTime getInstant() {
	return instant;
}

public void setInstant(LocalDateTime instant) {
	this.instant = instant;
}

public Pagamento getPagamento() {
	return pagamento;
}

public void setPagamento(Pagamento pagamento) {
	this.pagamento = pagamento;
}

public Cliente getCliente() {
	return cliente;
}

public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}

public Endereco getEnderecoDeEntrega() {
	return enderecoDeEntrega;
}

public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
	this.enderecoDeEntrega = enderecoDeEntrega;
}
@JsonIgnore
public List<Produto> getProdutos(){
	return itens.stream().map(x->x.getProduto()).collect(toList());
	
}
public Pedido() {

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
	Pedido other = (Pedido) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}


	
}
