package com.curso.domain.enums;

public enum TipoCliente {
  PESSOAFISICA(1,"PessoaFísica"),
  PESSOAJURIDICA(2,"PessoaJurídica");
  
  private String descricao;
  private int cod;
	
  TipoCliente(int cod,String descricao){
  this.descricao=descricao;
  this.cod=cod;
 	  
	  
  } 
  
 public static TipoCliente toTipoCliente(Integer cod) {
	 if(cod==null) {
	  return null;	 
		 
	 }
	 
	 for (TipoCliente c:TipoCliente.values()) {
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