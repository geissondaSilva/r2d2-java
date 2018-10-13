package com.engsoftware.r2d2.result;

import java.io.Serializable;
import java.util.List;

import com.engsoftware.r2d2.model.Acoes;
import com.engsoftware.r2d2.model.Funcionalidade;
import com.engsoftware.r2d2.model.Tags;

public class FuncionalidadeResult implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5931653770839627848L;
	
	private Funcionalidade funcionalidade;
	private Acoes acao;
	private List<Tags> tags;
	
	public Funcionalidade getFuncionalidade() {
		return funcionalidade;
	}
	public void setFuncionalidade(Funcionalidade funcionalidade) {
		this.funcionalidade = funcionalidade;
	}
	public Acoes getAcao() {
		return acao;
	}
	public void setAcao(Acoes acao) {
		this.acao = acao;
	}
	public List<Tags> getTags() {
		return tags;
	}
	public void setTags(List<Tags> tags) {
		this.tags = tags;
	}
}
