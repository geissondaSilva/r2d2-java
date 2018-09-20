package com.engsoftware.r2d2.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="mensagem")
@SequenceGenerator(name="MSG_SEQ", sequenceName="MENSAGEM_SEQ", initialValue=1, allocationSize=1)
public class Mensagem implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7983031862930127503L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="idconversa")
	private Long idConversa;
	
	@Transient
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idConversa", referencedColumnName="id")
	private Conversa conversa;
	
	@Column(name="idresposta")
	private Long idResposta;
	
	@Transient
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idResposta", referencedColumnName="id")
	private Resposta resposta;
	
	@NotNull(message="a resposta não pode ser nulla")
	@Column(length=1000, nullable=false)
	private String res;
	
	@Column(length=30)
	private String tipo;
	
	@Column(length=50)
	private String name;
	
	@Transient
	private Long idDialogo;
	
	public Long getIdDialogo() {
		return idDialogo;
	}



	public void setIdDialogo(Long idDialogo) {
		this.idDialogo = idDialogo;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataConversa;
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getIdConversa() {
		return idConversa;
	}



	public void setIdConversa(Long idConversa) {
		this.idConversa = idConversa;
	}



	public Conversa getConversa() {
		return conversa;
	}



	public void setConversa(Conversa conversa) {
		this.conversa = conversa;
	}



	public Long getIdResposta() {
		return idResposta;
	}



	public void setIdResposta(Long idResposta) {
		this.idResposta = idResposta;
	}



	public Resposta getResposta() {
		return resposta;
	}



	public void setResposta(Resposta resposta) {
		this.resposta = resposta;
	}



	public String getRes() {
		return res;
	}



	public void setRes(String res) {
		this.res = res;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public Date getDataConversa() {
		return dataConversa;
	}



	public void setDataConversa(Date dataConversa) {
		this.dataConversa = dataConversa;
	}



	@Override
	public String toString() {
		return "Mensagem [id=" + id + ", idConversa=" + idConversa + ", conversa=" + conversa + ", idResposta="
				+ idResposta + ", resposta=" + resposta + ", res=" + res + ", tipo=" + tipo + ", dataConversa="
				+ dataConversa + "]";
	}
	
	@PrePersist()
	public void prePersist() {
		this.dataConversa = new Date();
	}
	
}
