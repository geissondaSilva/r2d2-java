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

@Entity
@Table
public class Funcionalidade implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -896788877486212535L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Column(length=50)
	private String nome;
	
	@Column(length=200)
	private String descricao;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idacao", referencedColumnName="id", insertable=false, updatable=false)
	private Acoes acao;
	
	@Column(name="idacao")
	private Long idAcao;
	
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
	public Acoes getAcao() {
		return acao;
	}
	public void setAcao(Acoes acao) {
		this.acao = acao;
	}
	public Long getIdAcao() {
		return idAcao;
	}
	public void setIdAcao(Long idAcao) {
		this.idAcao = idAcao;
	}
}
