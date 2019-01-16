package com.curso.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import com.curso.domain.enums.EstadoPagamento;


@Entity
public class PagamentoComBoleto extends Pagamento {
 
	private LocalDateTime dataDeVencimento;
	private LocalDateTime dataDePagamento;
	public PagamentoComBoleto() {
	super();
	}
	public PagamentoComBoleto(Long id, EstadoPagamento estadoPagamento, Pedido pedido, LocalDateTime dataDeVencimento,
			LocalDateTime dataDePagamento) {
		super(id, estadoPagamento, pedido);
		this.dataDeVencimento = dataDeVencimento;
		this.dataDePagamento = dataDePagamento;
	}

	public LocalDateTime getDataDeVencimento() {
		return dataDeVencimento;
	}
	public void setDataDeVencimento(LocalDateTime dataDeVencimento) {
		this.dataDeVencimento = dataDeVencimento;
	}
	public LocalDateTime getDataDePagamento() {
		return dataDePagamento;
	}
	public void setDataDePagamento(LocalDateTime dataDePagamento) {
		this.dataDePagamento = dataDePagamento;
	}
	
 	
}
