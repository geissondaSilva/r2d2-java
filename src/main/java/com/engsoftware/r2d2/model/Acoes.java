package com.engsoftware.r2d2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="acoes")
@SequenceGenerator(name="ACO_SEQ", sequenceName="ACOES_SEQ", initialValue=1, allocationSize=1)
public class Acoes implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8327147638720344186L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@NotNull(message="campo nome não pode ser nullo")
	@Column(length=100, nullable=false)
	private String nome;
	
	@Column(length=200)
	private String descricao;
	
	@NotNull(message="Campo value não pode ser nullo")
	@Column(length=20, nullable=false)
	private String value;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Acoes [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", value=" + value + "]";
	}
}
