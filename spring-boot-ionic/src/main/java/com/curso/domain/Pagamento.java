package com.curso.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.curso.domain.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Pagamento implements Serializable	 {

private static final long serialVersionUID = 1L;
@Id 
private Long id;
private int estadoPagamento;
 @JsonIgnore
 @OneToOne
 @JoinColumn(name="pedido_id")
 @MapsId
 Pedido pedido;
 public Pagamento() {
	// TODO Auto-generated constructor stub
}

public Pagamento(Long id, EstadoPagamento estadoPagamento, Pedido pedido) {
	super();
	this.id = id;
	this.estadoPagamento = estadoPagamento.getCod();
	this.pedido = pedido;
}

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public EstadoPagamento getEstadoPagamento() {
	return EstadoPagamento.toEstadoPagamento(this.estadoPagamento);
}
public void setEstadoPagamento(EstadoPagamento estadoPagamento) {
	this.estadoPagamento = estadoPagamento.getCod();
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
	Pagamento other = (Pagamento) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}
	

}
