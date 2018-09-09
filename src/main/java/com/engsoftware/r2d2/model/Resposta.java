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
import javax.persistence.Transient;

@Entity
@Table(name="resposta")
@SequenceGenerator(name="RES_SEQ", sequenceName="RESPOSTA_SEQ", initialValue=1, allocationSize=1)
public class Resposta implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1172113785387474188L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="idpergunta")
	private Long idPergunta;
	
	@Transient
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idPergunta", referencedColumnName="id")
	private Pergunta pergunta;
	
	@Column(name="idacoes")
	private Long idAcoes;
	
	@Transient
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idAcoes", referencedColumnName="id")
	private Acoes acoes;
	
	@Column(length=500, nullable=false)
	private String value;
	
	@Column
	private Integer sequence;
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getIdPergunta() {
		return idPergunta;
	}


	public void setIdPergunta(Long idPergunta) {
		this.idPergunta = idPergunta;
	}


	public Pergunta getPergunta() {
		return pergunta;
	}


	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}


	public Long getIdAcoes() {
		return idAcoes;
	}


	public void setIdAcoes(Long idAcoes) {
		this.idAcoes = idAcoes;
	}


	public Acoes getAcoes() {
		return acoes;
	}


	public void setAcoes(Acoes acoes) {
		this.acoes = acoes;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	public Integer getSequence() {
		return sequence;
	}


	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}


	@Override
	public String toString() {
		return "Resposta [id=" + id + ", idPergunta=" + idPergunta + ", pergunta=" + pergunta + ", idAcao=" + idAcoes
				+ ", acoes=" + acoes + ", value=" + value + ", sequence=" + sequence + "]";
	}
	
}
