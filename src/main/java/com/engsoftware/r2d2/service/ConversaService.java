package com.engsoftware.r2d2.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engsoftware.r2d2.model.Conversa;
import com.engsoftware.r2d2.model.Dialogo;
import com.engsoftware.r2d2.model.Mensagem;
import com.engsoftware.r2d2.model.Pergunta;
import com.engsoftware.r2d2.repository.ConversaRepository;
import com.engsoftware.r2d2.repository.DialogoRepository;
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
	
	@Autowired
	DialogoRepository dialogoRepository;
	
	public Conversa novaConversa(Conversa conversa, String tipo) throws Exception{
		//salvar conversa
		
		Dialogo dialogo = new Dialogo();
		try {
			conversa = conversaRepository.save(conversa);
		}catch (Exception e) {
			throw e;
		}
		
		//buscar mensagens
		List<Pergunta> perguntas = new ArrayList<>();
		List<Mensagem> mensagens = new ArrayList<>();
		
		try {
			dialogo = dialogoRepository.buscarPorTipo("novo").get(0);
			//perguntas = perguntaRepository.buscarPerguntaPorTipo(tipo);
		}catch (Exception e) {
			throw e;
		}
		
		Mensagem msg = new Mensagem();
		msg.setDataConversa(new Date());
		msg.setIdConversa(conversa.getId());
		msg.setRes(dialogo.getMensagem());
		msg.setName("novodialogo");
		msg.setTipo("boot");
		msg.setIdDialogo(dialogo.getId());
		
		try {				
			msg = mensagemRepository.save(msg);
			mensagens.add(msg);
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Não foi possivel gravar as perguntas na tabela mensagem");
		}
		
		conversa.setMensagens(mensagens);
		return conversa;
	}
}
