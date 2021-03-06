package com.engsoftware.r2d2.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="pergunta")
@SequenceGenerator(name="PER_SEQ", sequenceName="PERGUNTA_SEQ", initialValue=1, allocationSize=1)
public class Pergunta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6184422769424786881L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@NotNull(message="campo pergunta não pode ser nullo")
	@Column(length=200, nullable=false)
	private String pergunta;
	
	@NotNull(message="campo tipo não pode ser nullo")
	@Column(length=20, nullable=false)
	private String tipo;
	
	@Column
	private Integer sequence;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUtilizacao;
	
	@Column(length=30)
	private String assunto;
	
	private Integer qtdTags;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPergunta() {
		return pergunta;
	}
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	public Date getDataUtilizacao() {
		return dataUtilizacao;
	}
	public void setDataUtilizacao(Date dataUtilizacao) {
		this.dataUtilizacao = dataUtilizacao;
	}
	
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public Integer getQtdTags() {
		return qtdTags;
	}
	public void setQtdTags(Integer qtdTags) {
		this.qtdTags = qtdTags;
	}
	@Override
	public String toString() {
		return "Pergunta [id=" + id + ", pergunta=" + pergunta + ", tipo=" + tipo + ", sequence=" + sequence
				+ ", dataUtilizacao=" + dataUtilizacao + ", assunto=" + assunto + "]";
	}
	
	
	
}
