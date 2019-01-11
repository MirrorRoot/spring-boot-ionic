package com.curso.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Estado implements Serializable {
 
 /**
	 * 
	 */
 private static final long serialVersionUID = 1L;
 
 @Id @GeneratedValue(strategy=GenerationType.AUTO)
 private Long id;
 private String name;
 private String sigla;
 
 @OneToMany(mappedBy="estado")
 private List<Cidade> cidades=new ArrayList<>();
 
public Estado() {
	// TODO Auto-generated constructor stub
} 
public Estado(Long id, String name, String sigla) {
	super();
	this.id = id;
	this.name = name;
	this.sigla = sigla;
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
public String getSigla() {
	return sigla;
}
public void setSigla(String sigla) {
	this.sigla = sigla;
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
	Estado other = (Estado) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}
 
	
}
