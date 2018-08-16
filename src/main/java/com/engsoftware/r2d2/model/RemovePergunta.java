package com.engsoftware.r2d2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class RemovePergunta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4106992007892955722L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Column(nullable=false, name="idpergunta")
	private Long idPergunta;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idPergunta", referencedColumnName="id")
	private Pergunta pergunta;
	
	@Column(nullable=false, name="idremover")
	private Long idRemover;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idRemover", referencedColumnName="id")
	private Remover remover;
	
	
	private Long getId() {
		return id;
	}


	private void setId(Long id) {
		this.id = id;
	}


	private Long getIdPergunta() {
		return idPergunta;
	}


	private void setIdPergunta(Long idPergunta) {
		this.idPergunta = idPergunta;
	}


	private Pergunta getPergunta() {
		return pergunta;
	}


	private void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}


	private Long getIdRemover() {
		return idRemover;
	}


	private void setIdRemover(Long idRemover) {
		this.idRemover = idRemover;
	}


	private Remover getRemover() {
		return remover;
	}


	private void setRemover(Remover remover) {
		this.remover = remover;
	}


	@Override
	public String toString() {
		return "RemovePergunta [id=" + id + ", idPergunta=" + idPergunta + ", idRemover=" + idRemover + "]";
	}
}
