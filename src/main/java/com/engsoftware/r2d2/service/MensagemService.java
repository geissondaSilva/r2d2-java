package com.engsoftware.r2d2.service;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engsoftware.r2d2.model.Dialogo;
import com.engsoftware.r2d2.model.DicionarioPalavrao;
import com.engsoftware.r2d2.model.DicionarioPergunta;
import com.engsoftware.r2d2.model.Funcionalidade;
import com.engsoftware.r2d2.model.Mensagem;
import com.engsoftware.r2d2.model.Pergunta;
import com.engsoftware.r2d2.model.Resposta;
import com.engsoftware.r2d2.model.Tags;
import com.engsoftware.r2d2.repository.DialogoRepository;
import com.engsoftware.r2d2.repository.DicionarioPalaraoRepository;
import com.engsoftware.r2d2.repository.DicionarioPerguntaRepository;
import com.engsoftware.r2d2.repository.MensagemRepostory;
import com.engsoftware.r2d2.repository.PerguntaRepository;
import com.engsoftware.r2d2.repository.RespostaRepository;
import com.engsoftware.r2d2.repository.TagsRepository;
import com.engsoftware.r2d2.result.FuncionalidadeTagResult;
import com.engsoftware.r2d2.result.PerguntaTagsResult;

@Service
public class MensagemService {
	
	@Autowired
	MensagemRepostory mensagemRepository;
	
	@Autowired
	DicionarioPalaraoRepository dicionarioPalavraoRepository;
	
	@Autowired
	DicionarioPerguntaRepository dicionarioPerguntaRepository;
	
	@Autowired
	PerguntaRepository perguntaRepository;
	
	@Autowired
	DialogoRepository dialogoRepository;
	
	@Autowired
	TagsRepository tagRepository;
	
	@Autowired
	RespostaRepository respostaRepository;
	
	@PersistenceContext
	private EntityManager entity;
	
	public List<Mensagem> novaMensagem(Mensagem mensagem, Long idPergunta) throws Exception{
		mensagemRepository.save(mensagem);
		
		List<Mensagem> mensagens = new ArrayList<>();
		Mensagem msg = filtrarPalavrao(mensagem.getRes());
		if(msg != null) {
			mensagens.add(msg);
			return gravaMensagens(mensagens);
		}
		
		msg = filtrarPergunta(mensagem);
		
		if(msg != null) {
			mensagens.add(msg);
			return gravaMensagens(mensagens);
		}
		
		if(idPergunta != 0) {
			return novoDialogo(mensagem.getIdConversa());
		}
		
		return naoEntendeu();
	}
	
	public List<Mensagem> gravaMensagens(List<Mensagem> msgs) throws Exception {
		for(Mensagem msg : msgs) {			
			msg = mensagemRepository.save(msg);
		}
		return msgs;
	}
	
	public Mensagem gravaMensagem(Mensagem msg) throws Exception {
		return mensagemRepository.save(msg);
	}
	
	public List<Mensagem> naoEntendeu() {
		return null;
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
	
	public Mensagem filtrarPergunta(Mensagem msg) throws Exception{
		List<DicionarioPergunta> dicionario = dicionarioPerguntaRepository.findAll();
		String frase = msg.getRes();
		List<String> palavras = separarPalavra(frase);
		int nivel = 0;
		for(DicionarioPergunta dic : dicionario) {
			for(String palavra : palavras) {
				if(palavra.equals(dic.getValue())) {
					nivel += dic.getNivel();
				}
			}
		}
		
		if(nivel >= 5) {
			return buscarRespostaPergunta(msg.getIdConversa(), msg);
		}
		return null;
	}
	
	public Mensagem buscarRespostaPergunta(Long idConversa, Mensagem msg) throws Exception{
		List<String> palavras = separarPalavra(msg.getRes());
		String cond = "";
		for(int i = 0;i < palavras.size();i++) {
			if(i == palavras.size() - 1) {
				cond += "'" + palavras.get(i) + "'";
				continue;
			}
			cond += "'" + palavras.get(i) + "', ";
		}
		
		String sql = "select t from Tags t where t.nome in (" + cond + ")";
		Query query = entity.createQuery(sql);
		List<Tags> tags = query.getResultList();
		List<PerguntaTagsResult> lista = montarPerguntaResulta(tags);
		for(PerguntaTagsResult p : lista) {
			if(p.getQtdTags() == p.getTags().size()) {
				Resposta resposta = respostaRepository.buscarPorPergunta(p.getId());
				Mensagem mensagem = new Mensagem();
				mensagem.setIdConversa(idConversa);
				mensagem.setIdResposta(resposta.getId());
				mensagem.setRes(p.getPergunta());
				mensagem.setTipo("resposta");
				mensagem.setResposta(resposta);
				return gravaMensagem(mensagem);
			}
		}		
		return semResposta();
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
	
	public Mensagem filtrarTag(Mensagem msg) {
		List<String> palavras = separarPalavra(msg.getRes());
		
		String cond = "";
		for(int i = 0;i < palavras.size();i++) {
			if(i == palavras.size() - 1) {
				cond += "'" + palavras.get(i) + "'";
				continue;
			}
			cond += "'" + palavras.get(i) + "', ";
		}
		
		String sql = "select t from Tags t where t.idfuncionalidade is not null and t.nome in (" + cond + ")";
		Query query = entity.createQuery(sql);
		List<Tags> tags = query.getResultList();
		
		List<FuncionalidadeTagResult> lista = montarFuncionalidadeResult(tags);
		return null;
	}
	
	private List<FuncionalidadeTagResult> montarFuncionalidadeResult(List<Tags> tags) {
		List<Funcionalidade> lista = new ArrayList<>();
		return null;
	}

	public String removeAcentos(String a) {
	    return Normalizer.normalize(a, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}
	
	
	public List<Mensagem> novoDialogo(Long idConversa){
		return null;
	}
	
	public List<PerguntaTagsResult> montarPerguntaResulta(List<Tags> tags){
		List<PerguntaTagsResult> perguntas = new ArrayList<>();
		for(Tags tag : tags) {
			//verificar se a pergunta ja foi adicionada
			boolean add = false;
			for(PerguntaTagsResult p : perguntas) {
				if(p.getId() == tag.getIdPergunta()) {
					List<Tags> lista = p.getTags();
					lista.add(tag);
					p.setTags(lista);
					add = true;
				}
			}
			if(!add) {
				PerguntaTagsResult per = new PerguntaTagsResult();
				per.setId(tag.getIdPergunta());
				per.setAssunto(tag.getPergunta().getAssunto());
				per.setPergunta(tag.getPergunta().getPergunta());
				per.setQtdTags(tag.getPergunta().getQtdTags());
				per.setSequence(tag.getPergunta().getSequence());
				List<Tags> lista = new ArrayList<>();
				lista.add(tag);
				per.setTags(lista);
				per.setTipo(tag.getPergunta().getTipo());
				perguntas.add(per);
			}
		}
		return perguntas;
	}
	
	public Mensagem semResposta() throws Exception{
		Mensagem msg = new Mensagem();
		msg.setRes("Desculpe minha ignorancia, mas eu estou sem resposta!");
		msg.setTipo("boot");
		return gravaMensagem(msg);
	}
}
