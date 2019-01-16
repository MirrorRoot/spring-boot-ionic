package com.curso.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Pedido implements Serializable  {


private static final long serialVersionUID = 1L;

@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

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

public Pedido() {

}


	
}
