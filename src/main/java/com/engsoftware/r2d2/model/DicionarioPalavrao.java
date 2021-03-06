package com.engsoftware.r2d2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="DicionarioPalavrao")
@SequenceGenerator(name="DIS_DIC_PAL", sequenceName="DICIONARIO_PALAVRAO_SEQ", initialValue=1, allocationSize=1)
public class DicionarioPalavrao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7978114283498533624L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	private Boolean deletado;
	
	@Column(length=50, nullable=false, name="nome")
	private String nome;
	
	@Column(length=50)
	private String value;
	
	private Integer nivel;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Boolean getDeletado() {
		return deletado;
	}
	public void setDeletado(Boolean deletado) {
		this.deletado = deletado;
	}
	public String getName() {
		return nome;
	}
	public void setName(String name) {
		this.nome = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "DicionarioPalavrao [id=" + id + ", deletado=" + deletado + ", nome=" + nome + ", value=" + value + "]";
	}
	public Integer getNivel() {
		return nivel;
	}
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
	

}
