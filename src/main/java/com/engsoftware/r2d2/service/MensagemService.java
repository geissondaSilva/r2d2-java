package com.engsoftware.r2d2.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.engsoftware.r2d2.model.Mensagem;
import com.engsoftware.r2d2.model.Pergunta;
import com.engsoftware.r2d2.repository.MensagemRepostory;


public class MensagemService {
	
	@Autowired
	MensagemRepostory mensagemRepository;
	
	public List<Mensagem> cadastrarMensagens(List<Pergunta> perguntas, Long idConversa) throws Exception{
		List<Mensagem> mensagens = new ArrayList<>();
		for(Pergunta p: perguntas) {
			Mensagem msg = new Mensagem();
			msg.setIdConversa(idConversa);
			msg.setRes(p.getPergunta());
			msg.setDataConversa(new Date(System.currentTimeMillis()));
			msg.setTipo("pergunta");
			try {				
				msg = mensagemRepository.save(msg);
			}catch (Exception e) {
				throw e;
			}
			mensagens.add(msg);
		}
		
		return mensagens;
	}
}
