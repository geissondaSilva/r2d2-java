package com.engsoftware.r2d2.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="usuario")
@SequenceGenerator(name="USER_SEQ", sequenceName="USUARIO_SEQ", initialValue=1, allocationSize=1)
public class Usuario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6828671334857336714L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@NotNull(message="campo login não pode ser nullo")
	@Column(length=100, nullable=false)
	private String login;
	
	@NotNull(message="campo senha não pode ser nullo")
	@Column(length=200, nullable=false)
	private String senha;
	
	@NotNull(message="campo email não pode ser nullo")
	@Column(length=100, nullable=false)
	private String email;
	
	@Column(length=100)
	private String token;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + ", senha=" + senha + ", email=" + email + ", token=" + token
				+ ", dataCadastro=" + dataCadastro + "]";
	}
	
}
