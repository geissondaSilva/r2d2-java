package com.engsoftware.r2d2.impl;

import java.util.List;

import com.engsoftware.r2d2.dto.NovaConversaDto;
import com.engsoftware.r2d2.model.Mensagem;
import com.engsoftware.r2d2.model.Pergunta;

public interface ConversaImpl {
	
	public NovaConversaDto novaConversa(NovaConversaDto nova) throws Exception;
	public List<Mensagem> cadastrarMensagens(List<Pergunta> perguntas, Long idConversa) throws Exception;
	
}
