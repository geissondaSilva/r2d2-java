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
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataConversa;
	
	private Long getId() {
		return id;
	}
	private void setId(Long id) {
		this.id = id;
	}
	private Long getIdConversa() {
		return idConversa;
	}
	private void setIdConversa(Long idConversa) {
		this.idConversa = idConversa;
	}
	private Conversa getConversa() {
		return conversa;
	}
	private void setConversa(Conversa conversa) {
		this.conversa = conversa;
	}
	private Long getIdResposta() {
		return idResposta;
	}
	private void setIdResposta(Long idResposta) {
		this.idResposta = idResposta;
	}
	private Resposta getResposta() {
		return resposta;
	}
	private void setResposta(Resposta resposta) {
		this.resposta = resposta;
	}
	private String getRes() {
		return res;
	}
	private void setRes(String res) {
		this.res = res;
	}
	private String getTipo() {
		return tipo;
	}
	private void setTipo(String tipo) {
		this.tipo = tipo;
	}
	private Date getDataConversa() {
		return dataConversa;
	}
	private void setDataConversa(Date dataConversa) {
		this.dataConversa = dataConversa;
	}
	@Override
	public String toString() {
		return "Mensagem [id=" + id + ", idConversa=" + idConversa + ", conversa=" + conversa + ", idResposta="
				+ idResposta + ", resposta=" + resposta + ", res=" + res + ", tipo=" + tipo + ", dataConversa="
				+ dataConversa + "]";
	}
	
}
