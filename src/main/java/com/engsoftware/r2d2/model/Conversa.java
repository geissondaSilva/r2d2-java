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

@Entity
@Table(name="conversa")
@SequenceGenerator(name="CON_SEQ", sequenceName="CONVERSA_SEQ", initialValue=1, allocationSize=1)
public class Conversa implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1616754610824698267L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataConversa;
	
	@Column(name="idusuario")
	private Long idUsuario;
	
	@Transient
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idUsuario", referencedColumnName="id")
	private Usuario usuario;
	
	private Long getId() {
		return id;
	}
	private void setId(Long id) {
		this.id = id;
	}
	private Date getDataConversa() {
		return dataConversa;
	}
	private void setDataConversa(Date dataConversa) {
		this.dataConversa = dataConversa;
	}
	private Long getIdUsuario() {
		return idUsuario;
	}
	private void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	private Usuario getUsuario() {
		return usuario;
	}
	private void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public String toString() {
		return "Conversa [id=" + id + ", dataConversa=" + dataConversa + ", idUsuario=" + idUsuario + ", usuario="
				+ usuario + "]";
	}
	
}
