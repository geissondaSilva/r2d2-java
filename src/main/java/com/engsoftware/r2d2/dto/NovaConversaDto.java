package com.engsoftware.r2d2.dto;

import java.util.ArrayList;
import java.util.List;

import com.engsoftware.r2d2.model.Conversa;
import com.engsoftware.r2d2.model.Mensagem;

public class NovaConversaDto {
	
	private Conversa conversa;
	private List<Mensagem> mensagens = new ArrayList<>();
	
	public Conversa getConversa() {
		return conversa;
	}
	public void setConversa(Conversa conversa) {
		this.conversa = conversa;
	}
	public List<Mensagem> getMensagens() {
		return mensagens;
	}
	public void setMensagens(List<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}
	
	
}
