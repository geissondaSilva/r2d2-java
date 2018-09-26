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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="dialogo")
public class Dialogo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6695859549106200106L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Column(length=50)
	private String mensagem;
	
	@Column(length=30)
	private String tipo;
	
	@Column(length=30)
	private String name;
	
	private Integer sequence;
	
	@Column(length=50)
	private String respostaAfirmacao;
	
	@Column(length=50)
	private String respostaNegacao;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idresposta", referencedColumnName="id", insertable=false, updatable=false)
	private Resposta resposta;
	
	@Column(name="idresposta")
	private Long idResposta;
	
	private Long filha;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUtilizacao;
	
	public String getRespostaAfirmacao() {
		return respostaAfirmacao;
	}
	public void setRespostaAfirmacao(String respostaAfirmacao) {
		this.respostaAfirmacao = respostaAfirmacao;
	}
	public String getRespostaNegacao() {
		return respostaNegacao;
	}
	public void setRespostaNegacao(String respostaNegacao) {
		this.respostaNegacao = respostaNegacao;
	}
	public Date getDataUtilizacao() {
		return dataUtilizacao;
	}
	public void setDataUtilizacao(Date dataUtilizacao) {
		this.dataUtilizacao = dataUtilizacao;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	public Resposta getResposta() {
		return resposta;
	}
	public void setResposta(Resposta resposta) {
		this.resposta = resposta;
	}
	public Long getIdResposta() {
		return idResposta;
	}
	public void setIdResposta(Long idResposta) {
		this.idResposta = idResposta;
	}
	public Long getFilha() {
		return filha;
	}
	public void setFilha(Long filha) {
		this.filha = filha;
	}
	
}
