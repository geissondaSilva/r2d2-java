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
@Table(name="dispositivo")
@SequenceGenerator(name="DIS_SEQ", sequenceName="DISPOSITIVO_SEQ", initialValue=1, allocationSize=1)
public class Dispositivo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8014097508553394507L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Column(length=100)
	private String serial;
	
	@Column(length=100)
	private String uuid;
	
	@Column(length=100)
	private String plataforma;
	
	@Column(length=100)
	private String versao;
	
	@Column(length=100)
	private String nome;
	
	@Column(name="idUsuario")
	private Long idUsuario;
	
	@Transient
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUsuario", referencedColumnName="id")
	private Usuario usuario;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getPlataforma() {
		return plataforma;
	}
	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	public String getVersao() {
		return versao;
	}
	public void setVersao(String versao) {
		this.versao = versao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	@Override
	public String toString() {
		return "Dispositivo [id=" + id + ", serial=" + serial + ", uuid=" + uuid + ", plataforma=" + plataforma
				+ ", versao=" + versao + ", nome=" + nome + ", idUsuario=" + idUsuario + ", usuario=" + usuario + "]";
	}
	
}
