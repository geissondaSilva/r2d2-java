package com.engsoftware.r2d2.result;

import java.io.Serializable;
import java.util.List;

import com.engsoftware.r2d2.model.Pergunta;
import com.engsoftware.r2d2.model.Resposta;
import com.engsoftware.r2d2.model.Tags;

public class PerguntaResult implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3161462631744367695L;
	
	private Pergunta pergunta;
	private List<Tags> tags;
	private Resposta resposta;
	
	public Pergunta getPergunta() {
		return pergunta;
	}
	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}
	public Resposta getResposta() {
		return resposta;
	}
	public void setResposta(Resposta resposta) {
		this.resposta = resposta;
	}
	public List<Tags> getTags() {
		return tags;
	}
	public void setTags(List<Tags> tags) {
		this.tags = tags;
	}
}
