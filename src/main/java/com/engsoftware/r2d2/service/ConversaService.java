package com.engsoftware.r2d2.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engsoftware.r2d2.dto.NovaConversaDto;
import com.engsoftware.r2d2.impl.ConversaImpl;
import com.engsoftware.r2d2.model.Conversa;
import com.engsoftware.r2d2.model.Mensagem;
import com.engsoftware.r2d2.model.Pergunta;
import com.engsoftware.r2d2.repository.ConversaRepository;
import com.engsoftware.r2d2.repository.MensagemRepostory;
import com.engsoftware.r2d2.repository.PerguntaRepository;

@Service
public class ConversaService implements ConversaImpl{
	
	@Autowired
	ConversaRepository conversaRepository;
	
	@Autowired
	PerguntaRepository perguntaRepository;
	
	@Autowired
	MensagemRepostory mensagemRepository;
	
	public NovaConversaDto novaConversa(NovaConversaDto nova) throws Exception{
		Conversa con;
		
		try {			
			con = conversaRepository.save(nova.getConversa());
		}catch (Exception e) {
			throw e;
		}
		
		nova.setConversa(con);
		
		List<Pergunta> perguntas = new ArrayList<>();
		
		try {
			perguntas = perguntaRepository.buscarInicioConversa();
		}catch (Exception e) {
			throw e;
		}
		
		List<Mensagem> msgs = cadastrarMensagens(perguntas, con.getId());
		nova.setMensagens(msgs);
		return nova;
	}
	
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