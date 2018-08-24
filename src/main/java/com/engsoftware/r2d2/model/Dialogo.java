package com.engsoftware.r2d2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dialogo")
public class Dialogo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6695859549106200106L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Column(length=50)
	private String mensagem;
	
	@Column(length=30)
	private String tipo;
	
	@Column(length=30)
	private String name;
	
	private Integer sequence;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	@Override
	public String toString() {
		return "Dialogo [id=" + id + ", mensagem=" + mensagem + ", tipo=" + tipo + ", name=" + name + ", sequence="
				+ sequence + "]";
	}
	
}
