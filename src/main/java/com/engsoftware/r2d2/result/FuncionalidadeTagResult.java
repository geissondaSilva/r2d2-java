package com.engsoftware.r2d2.result;

import java.util.List;

import com.engsoftware.r2d2.model.Acoes;
import com.engsoftware.r2d2.model.Tags;

public class FuncionalidadeTagResult {
	
	private Long id;
	private String nome;
	private List<Tags> tags;
	private Long idAcao;
	private Acoes acao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Tags> getTags() {
		return tags;
	}
	public void setTags(List<Tags> tags) {
		this.tags = tags;
	}
	public Long getIdAcao() {
		return idAcao;
	}
	public void setIdAcao(Long idAcao) {
		this.idAcao = idAcao;
	}
	public Acoes getAcao() {
		return acao;
	}
	public void setAcao(Acoes acao) {
		this.acao = acao;
	}
	
	
}
