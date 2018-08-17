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
@Table(name="tags")
@SequenceGenerator(name="TAG_SEQ", sequenceName="TAGS_SEQ", initialValue=1, allocationSize=1)
public class Tags implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5788605909551395476L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@NotNull(message="Campo nome não pode ser nullo")
	@Column(length=50, nullable=false)
	private String nome;
	
	@Column(length=200)
	private String descricao;
	
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
	@Override
	public String toString() {
		return "Tags [id=" + id + ", nome=" + nome + ", descricao=" + descricao + "]";
	}
	
	
}
