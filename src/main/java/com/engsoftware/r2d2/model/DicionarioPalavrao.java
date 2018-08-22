package com.engsoftware.r2d2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="DicionarioPalavrao")
@SequenceGenerator(name="DIS_DIC_PAL", sequenceName="DICIONARIO_PALAVRAO_SEQ", initialValue=1, allocationSize=1)
public class DicionarioPalavrao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7978114283498533624L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	private Boolean deletado;
	
	@Column(length=50, nullable=false)
	private String name;
	
	@Column(length=50)
	private String value;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getDeletado() {
		return deletado;
	}
	public void setDeletado(Boolean deletado) {
		this.deletado = deletado;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "DicionarioPalavrao [id=" + id + ", deletado=" + deletado + ", name=" + name + ", value=" + value + "]";
	}

}
