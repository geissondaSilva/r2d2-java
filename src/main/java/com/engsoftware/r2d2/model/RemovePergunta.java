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
@Table(name="removepergunta")
@SequenceGenerator(name="REMPER_SEQ", sequenceName="REMOVER_PERGUNTA_SEQ", initialValue=1, allocationSize=1)
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
	
	@Transient
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idPergunta", referencedColumnName="id")
	private Pergunta pergunta;
	
	@Column(nullable=false, name="idremover")
	private Long idRemover;
	
	@Transient
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idRemover", referencedColumnName="id")
	private Remover remover;
	
	


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




	public Long getIdRemover() {
		return idRemover;
	}




	public void setIdRemover(Long idRemover) {
		this.idRemover = idRemover;
	}




	public Remover getRemover() {
		return remover;
	}




	public void setRemover(Remover remover) {
		this.remover = remover;
	}




	@Override
	public String toString() {
		return "RemovePergunta [id=" + id + ", idPergunta=" + idPergunta + ", idRemover=" + idRemover + "]";
	}
}
