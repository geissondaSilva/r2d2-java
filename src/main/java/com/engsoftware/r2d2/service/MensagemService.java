package com.engsoftware.r2d2.service;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engsoftware.r2d2.model.Dialogo;
import com.engsoftware.r2d2.model.DicionarioPalavrao;
import com.engsoftware.r2d2.model.Mensagem;
import com.engsoftware.r2d2.repository.DialogoRepository;
import com.engsoftware.r2d2.repository.DicionarioPalaraoRepository;
import com.engsoftware.r2d2.repository.MensagemRepostory;
import com.engsoftware.r2d2.repository.PerguntaRepository;

@Service
public class MensagemService {
	
	@Autowired
	MensagemRepostory mensagemRepository;
	
	@Autowired
	DicionarioPalaraoRepository dicionarioPalavraoRepository;
	
	@Autowired
	PerguntaRepository perguntaRepository;
	
	@Autowired
	DialogoRepository dialogoRepository;
	
	public List<Mensagem> novaMensagem(Mensagem mensagem) throws Exception{
		Mensagem msg = filtrarPalavrao(mensagem.getRes());
		List<Mensagem> mensagens = new ArrayList<>();
		mensagens.add(msg);
		return mensagens;
	}
	
	public Mensagem filtrarPalavrao(String frase){
		List<DicionarioPalavrao> palavroes = new ArrayList<>();
		try {
			palavroes = dicionarioPalavraoRepository.findAll();
		}catch (Exception e) {
			throw e;
		}
		
		String[] lista;
		frase = removeAcentos(frase);
		frase = frase.toUpperCase();
		lista = frase.split(" ");
		List<String> nova = new ArrayList<>();
		for(String a : lista) {
			nova.add(a);
		}
		
		Integer quantidadePalavroes = 0;
		
		for(String e : nova) {
			for(DicionarioPalavrao p : palavroes) {
				if(e.equals(p.getValue())) {
					quantidadePalavroes++;
				}
			}
		}
		
		if(quantidadePalavroes > 0) {
			//tirar porcentagem da quantidade de palavroes
			Integer per = (quantidadePalavroes * 100) / nova.size();
			String busca = "";
			if(per < 25) {
				busca = "besterento";
			}else if(per < 50) {
				busca = "piapancudo";
			}else if(per < 75) {
				busca = "filhadaputa";
			}else {
				busca = "hardmerda";
			}
			
			Dialogo dialogo = dialogoRepository.buscarPorNameTipo(busca, "palavrao").get(0);
			Mensagem msg = new Mensagem();
			msg.setDataConversa(new Date());
			msg.setRes(dialogo.getMensagem());

			msg.setTipo("boot");
			return msg;
		}
		return null;
	}
	
	public List<String> separarPalavra(String frase){
		String[] lista;
		frase = removeAcentos(frase);
		frase = frase.toUpperCase();
		lista = frase.split(" ");
		List<String> nova = new ArrayList<>();
		for(String a : lista) {
			nova.add(a);
		}
		return nova;
	}
	
	public String removeAcentos(String a) {
	    return Normalizer.normalize(a, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}
	
	public Mensagem vereficarPergunta(String msg) {
		List<String> palavras = separarPalavra(msg);
		return null;
	}
}
