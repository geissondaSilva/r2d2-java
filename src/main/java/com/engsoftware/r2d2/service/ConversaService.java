package com.engsoftware.r2d2.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engsoftware.r2d2.model.Conversa;
import com.engsoftware.r2d2.model.Mensagem;
import com.engsoftware.r2d2.model.Pergunta;
import com.engsoftware.r2d2.repository.ConversaRepository;
import com.engsoftware.r2d2.repository.MensagemRepostory;
import com.engsoftware.r2d2.repository.PerguntaRepository;

@Service
public class ConversaService {
	
	@Autowired
	ConversaRepository conversaRepository;
	
	@Autowired
	PerguntaRepository perguntaRepository;
	
	@Autowired
	MensagemRepostory mensagemRepository;
	
	public Conversa novaConversa(Conversa conversa, String tipo) throws Exception{
		//salvar conversa
		
		try {
			conversa = conversaRepository.save(conversa);
		}catch (Exception e) {
			throw e;
		}
		
		//buscar mensagens
		List<Pergunta> perguntas = new ArrayList<>();
		List<Mensagem> mensagens = new ArrayList<>();
		
		try {
			perguntas = perguntaRepository.buscarPerguntaPorTipo(tipo);
		}catch (Exception e) {
			throw e;
		}
		
		//salvar as mensagens da conversa
		for(Pergunta p : perguntas) {
			Mensagem msg = new Mensagem();
			msg.setDataConversa(new Date());
			msg.setIdConversa(conversa.getId());
			msg.setRes(p.getPergunta());
			msg.setTipo("boot");
			try {				
				msg = mensagemRepository.save(msg);
				mensagens.add(msg);
			}catch (Exception e) {
				e.printStackTrace();
				throw new Exception("Não foi possivel gravar as perguntas na tabela mensagem");
			}
		}
		
		conversa.setMensagens(mensagens);
		return conversa;
	}
}
