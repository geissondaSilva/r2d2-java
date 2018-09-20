package com.engsoftware.r2d2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="dicionario")
public class Dicionario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6649492176907835099L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@NotNull(message="Campo value não pode ser nullo")
	@Column(length=50)
	private String value;
	
	@NotNull(message="Campo tipo não pode ser nullo")
	@Column(length=50)
	private String tipo;
	
	@Column(length=50)
	private String name;
	
	@Column(name="iddialogo")
	private Long idDialogo;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="iddialogo", referencedColumnName="id", insertable=false, updatable=false)
	private Dialogo dialogo;
	
	private Integer nivel;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getIdDialogo() {
		return idDialogo;
	}
	public void setIdDialogo(Long idDialogo) {
		this.idDialogo = idDialogo;
	}
	public Dialogo getDialogo() {
		return dialogo;
	}
	public void setDialogo(Dialogo dialogo) {
		this.dialogo = dialogo;
	}
	public Integer getNivel() {
		return nivel;
	}
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

}
