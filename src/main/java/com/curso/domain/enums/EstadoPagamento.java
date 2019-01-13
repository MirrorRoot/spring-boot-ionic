package com.curso.domain.enums;

public enum EstadoPagamento {
  PENDENTE(1,"Pendente"),
  QUITADO(2,"Quitado"),
  CANCELADO(3,"Cancelado");
  
  private String descricao;
  private int cod;
	
  EstadoPagamento(int cod,String descricao){
  this.descricao=descricao;
  this.cod=cod;
 	  
	  
  } 
  
 public static EstadoPagamento toEstadoPagamento(Integer cod) {
	 if(cod==null) {
	  return null;	 
		 
	 }
	 
	 for (EstadoPagamento c:EstadoPagamento.values()) {
	  if(cod.equals(c.cod)) {
		 return c;  
		  
	  }     	 
	  	
	 }
	 throw new IllegalArgumentException("cod:"+ cod + "invalido");
	 
 }
 
	public String getDescricao(){
	return this.descricao;	
		
	} 
	public int getCod(){
		return this.cod ;	
			
		}
}