package com.engsoftware.r2d2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Table
public class Remover implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3312945992104523075L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@NotNull(message="campo value não pode ser nullo")
	@Column(length=100, nullable=false)
	private String value;
	
	@NotNull(message="campo tipo não pode ser nullo")
	@Column(length=30, nullable=false)
	private String tipo;
	
	@Column
	private Integer urgencia;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Integer getUrgencia() {
		return urgencia;
	}
	public void setUrgencia(Integer urgencia) {
		this.urgencia = urgencia;
	}
	
	
	@Override
	public String toString() {
		return "Remover [id=" + id + ", value=" + value + ", tipo=" + tipo + ", urgencia=" + urgencia + "]";
	}
	
	
}
