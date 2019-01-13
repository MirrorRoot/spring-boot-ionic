package com.curso.domain;

import javax.persistence.Entity;

import com.curso.domain.enums.EstadoPagamento;

public class PagamentoComCartao extends Pagamento {

	private int numeroDeParcelas;
	public PagamentoComCartao() {
		// TODO Auto-generated constructor stub
	}
	public PagamentoComCartao(Long id, EstadoPagamento estadoPagamento, Pedido pedido, int numeroDeParcelas) {
		super(id, estadoPagamento, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}
	public int getNumeroDeParcelas() {
		return numeroDeParcelas;
	}
	public void setNumeroDeParcelas(int numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
}
