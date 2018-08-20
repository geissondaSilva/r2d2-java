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
	
	@Column(name="iddispositivo")
	private Long idDispositivo;
	
	@Transient
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idDispositivo", referencedColumnName="id")
	private Dispositivo dispositivo;
	
	public Long getIdDispositivo() {
		return idDispositivo;
	}



	public void setIdDispositivo(Long idDispositivo) {
		this.idDispositivo = idDispositivo;
	}



	public Dispositivo getDispositivo() {
		return dispositivo;
	}



	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Date getDataConversa() {
		return dataConversa;
	}



	public void setDataConversa(Date dataConversa) {
		this.dataConversa = dataConversa;
	}



	@Override
	public String toString() {
		return "Conversa [id=" + id + ", dataConversa=" + dataConversa + ", idDispositivo=" + idDispositivo
				+ ", dispositivo=" + dispositivo + "]";
	}

	
}
