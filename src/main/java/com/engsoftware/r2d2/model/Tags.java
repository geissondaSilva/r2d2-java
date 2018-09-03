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
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idpergunta", referencedColumnName="id", insertable=false, updatable=false)
	private Pergunta pergunta;
	
	@Column(name="idpergunta")
	private Long idPergunta;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idfuncionalidade", referencedColumnName="id", insertable=false, updatable=false)
	private Funcionalidade funcionalidade;
	
	@Column(name="idfuncionalidade")
	private Long idFuncionalidade;
	
	public Funcionalidade getFuncionalidade() {
		return funcionalidade;
	}
	public void setFuncionalidade(Funcionalidade funcionalidade) {
		this.funcionalidade = funcionalidade;
	}
	public Long getIdFuncionalidade() {
		return idFuncionalidade;
	}
	public void setIdFuncionalidade(Long idFuncionalidade) {
		this.idFuncionalidade = idFuncionalidade;
	}
	public Pergunta getPergunta() {
		return pergunta;
	}
	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}
	public Long getIdPergunta() {
		return idPergunta;
	}
	public void setIdPergunta(Long idPergunta) {
		this.idPergunta = idPergunta;
	}
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
