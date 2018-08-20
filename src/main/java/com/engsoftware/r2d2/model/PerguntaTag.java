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

@Entity
@Table(name="perguntatag")
@SequenceGenerator(name="PERTAG_SEQ", sequenceName="PERGUNTA_TAG_SEQ", initialValue=1, allocationSize=1)
public class PerguntaTag implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6842665878118816044L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="idtag")
	private Long idTag;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn()
	private Tags tag;
	
	@Column(name="idpergunta")
	private Long idPergunta;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Pergunta pergunta;
																																																																
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getIdTag() {
		return idTag;
	}


	public void setIdTag(Long idTag) {
		this.idTag = idTag;
	}


	public Tags getTag() {
		return tag;
	}


	public void setTag(Tags tag) {
		this.tag = tag;
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


	@Override
	public String toString() {
		return "PerguntaTag [id=" + id + ", idTag=" + idTag + ", tag=" + tag + ", idPergunta=" + idPergunta
				+ ", pergunta=" + pergunta + "]";
	}
	
	
}
