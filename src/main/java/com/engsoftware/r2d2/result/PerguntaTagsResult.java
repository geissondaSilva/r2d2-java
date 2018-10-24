package com.engsoftware.r2d2.result;

import java.util.List;

import com.engsoftware.r2d2.model.Tags;

public class PerguntaTagsResult {
	
	private Long id;
	private List<Tags> tags;
	private Integer qtdTags;
	private String pergunta;
	private Integer sequence;
	private String assunto;
	private String tipo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Tags> getTags() {
		return tags;
	}
	public void setTags(List<Tags> tags) {
		this.tags = tags;
	}
	public Integer getQtdTags() {
		return qtdTags;
	}
	public void setQtdTags(Integer qtdTags) {
		this.qtdTags = qtdTags;
	}
	public String getPergunta() {
		return pergunta;
	}
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return "PerguntaTagsResult [id=" + id + ", tags=" + tags + ", qtdTags=" + qtdTags + ", pergunta=" + pergunta
				+ ", sequence=" + sequence + ", assunto=" + assunto + ", tipo=" + tipo + "]";
	}
	
}
