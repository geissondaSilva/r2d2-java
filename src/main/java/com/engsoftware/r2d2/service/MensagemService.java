package com.engsoftware.r2d2.service;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engsoftware.r2d2.model.Acoes;
import com.engsoftware.r2d2.model.Dialogo;
import com.engsoftware.r2d2.model.DicionarioPalavrao;
import com.engsoftware.r2d2.model.DicionarioPergunta;
import com.engsoftware.r2d2.model.Mensagem;
import com.engsoftware.r2d2.model.Resposta;
import com.engsoftware.r2d2.model.Tags;
import com.engsoftware.r2d2.repository.AcaoRepository;
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
	
	@Autowired
	AcaoRepository acaoRepository;
	
	@PersistenceContext
	private EntityManager entity;
	
	public List<Mensagem> novaMensagem(Mensagem mensagem, Long idPergunta) throws Exception{
		mensagemRepository.save(mensagem);
		
		List<Mensagem> mensagens = new ArrayList<>();
		Mensagem msg = filtrarPalavrao(mensagem.getRes(), mensagem);
		if(msg != null) {
			mensagens.add(msg);
			return gravaMensagens(mensagens);
		}
		
		msg = filtrarPergunta(mensagem);
		
		if(msg != null) {
			mensagens.add(msg);
			return gravaMensagens(mensagens);
		}
		
		msg = filtrarFuncionalidade(mensagem);
		if(msg != null) {
			mensagens.add(msg);
			return gravaMensagens(mensagens);
		}
		
		if(idPergunta != null) {
			if(idPergunta == 0) {
				return naoEntendeu(mensagem);
			}
			return novoDialogo(mensagem.getIdConversa());
		}
		
		return naoEntendeu(mensagem);
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
	
	public List<Mensagem> naoEntendeu(Mensagem msg) throws Exception{
		Mensagem mensagem = new Mensagem();
		mensagem.setRes("Desculpe, mas não entendi o que você quiz dizer");
		mensagem.setIdConversa(msg.getIdConversa());
		mensagem.setTipo("boot");
		List<Mensagem> lista = new ArrayList<>();
		lista.add(mensagem);
		return gravaMensagens(lista);
	}
	
	public Mensagem filtrarPalavrao(String frase, Mensagem mensg){
		List<DicionarioPalavrao> palavroes = new ArrayList<>();
		List<String> listaPalavras = separarPalavra(frase);
		String cond = "";
		for(int i = 0;i < listaPalavras.size();i++) {
			if(i == listaPalavras.size() - 1) {
				cond += "'" + listaPalavras.get(i) + "'";
				continue;
			}
			cond += "'" + listaPalavras.get(i) + "', ";
		}
		
		try {
			String sql = "select dp from DicionarioPalavrao dp where dp.deletado = false and dp.value in (" + cond + ")";
			Query query = entity.createQuery(sql);
			palavroes = query.getResultList();
		}catch (Exception e) {
			throw e;
		}
		
		
		if(palavroes == null) {
			return null;
		}else if(palavroes.size() == 0) {
			return null;
		}
		
		Integer nivel = 0;
		
		for(DicionarioPalavrao dp : palavroes) {
			nivel += dp.getNivel();
		}
		
		String busca = null;
		
		if(nivel < 5) {
			busca = "leve";
		}else if(nivel < 10) {
			busca = "medio";
		}else if(nivel < 15) {
			busca = "maleducado";
		}else if(nivel < 20) {
			busca = "pesado";
		}else if(nivel >= 20) {
			busca = "pesadao";
		}else {
			return null;
		}
		
		List<Dialogo> listaRes = dialogoRepository.buscarPorNameTipo(busca, "palavrao");
		boolean existe = true;
		
		if(listaRes == null) {
			existe = false;
		}else if(listaRes.size() == 0) {
			existe = false;
		}
		
		if(!existe) {
			Mensagem msg = new Mensagem();
			msg.setDataConversa(new Date());
			msg.setRes("Me respeite!");
			msg.setIdConversa(mensg.getIdConversa());
			msg.setTipo("boot");
			return msg;
		}
		
		Dialogo dialogo = listaRes.get(0);
		Mensagem msg = new Mensagem();
		msg.setDataConversa(new Date());
		msg.setRes(dialogo.getMensagem());
		msg.setIdConversa(mensg.getIdConversa());
		msg.setTipo("boot");
		return msg;
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
		
		if(msg.getRes().contains("?")) {
			String a = msg.getRes().replace("?", "");
			msg.setRes(a);
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
		lista = ordenarPergunta(lista);
		for(PerguntaTagsResult p : lista) {
			if(p.getQtdTags() >= p.getTags().size()) {
				Resposta resposta = respostaRepository.buscarPorPergunta(p.getId());
				if(resposta == null) {
					return semResposta(idConversa);
				}
				Mensagem mensagem = new Mensagem();
				mensagem.setIdConversa(idConversa);
				mensagem.setIdResposta(resposta.getId());
				mensagem.setRes(p.getPergunta());
				mensagem.setTipo("resposta");
				mensagem.setResposta(resposta);
				return gravaMensagem(mensagem);
			}
		}		
		return semResposta(idConversa);
	}
	
	public List<PerguntaTagsResult> ordenarPergunta(List<PerguntaTagsResult> lista) {
		List<PerguntaTagsResult> nova = new ArrayList<>();
		int tamanho = lista.size();
		for(int a = 0;a < tamanho;a++) {
			int maior = 0, p = 0;			
			for(int j = 0;j < lista.size();j++) {
				if(lista.get(j).getTags().size() >= maior) {
					p = j;
					maior = lista.get(j).getTags().size();
				}
			}
			nova.add(lista.get(p));
			lista.remove(p);
		}
		return nova;
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
	
	public Mensagem filtrarFuncionalidade(Mensagem msg) {
		List<String> palavras = separarPalavra(msg.getRes());
		
		String cond = "";
		for(int i = 0;i < palavras.size();i++) {
			if(i == palavras.size() - 1) {
				cond += "'" + palavras.get(i) + "'";
				continue;
			}
			cond += "'" + palavras.get(i) + "', ";
		}
		
		String sql = "select t from Tags t where t.idFuncionalidade is not null and t.nome in (" + cond + ")";
		Query query = entity.createQuery(sql);
		List<Tags> tags = query.getResultList();
		
		List<FuncionalidadeTagResult> lista = montarFuncionalidadeResult(tags);
		
		for(FuncionalidadeTagResult fun : lista) {
			if(fun.getQtdTags() == fun.getTags().size()) {
				Mensagem mensg = new Mensagem();
				mensg.setIdConversa(msg.getIdConversa());
				if(fun.getAcao() == null) {
					Acoes acao = acaoRepository.getOne(fun.getIdAcao());
					fun.setAcao(acao);
				}
				mensg.setRes(fun.getAcao().getNome());
				mensg.setName(fun.getAcao().getValue());
				mensg.setTipo("acao");
				return mensg;
			}
		}
		
		return null;
	}
	
	private List<FuncionalidadeTagResult> montarFuncionalidadeResult(List<Tags> tags) {
		List<FuncionalidadeTagResult> lista = new ArrayList<>();
		for(Tags t : tags) {
			Boolean existe = false;
			for(FuncionalidadeTagResult fun : lista) {
				if(fun.getId() == t.getIdFuncionalidade()) {
					List<Tags> list = fun.getTags();
					list.add(t);
					fun.setTags(list);
					existe = true;
				}
			}
			
			if(!existe) {
				FuncionalidadeTagResult fun = new FuncionalidadeTagResult();
				fun.setId(t.getIdFuncionalidade());
				fun.setNome(t.getFuncionalidade().getNome());
				fun.setIdAcao(t.getFuncionalidade().getIdAcao());
				fun.setQtdTags(t.getFuncionalidade().getQtdTags());
				List<Tags> list = new ArrayList<>();
				list.add(t);
				fun.setTags(list);
				lista.add(fun);
			}
		}
		return lista;
	}

	public String removeAcentos(String a) {
	    return Normalizer.normalize(a, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}
	
	
	public List<Mensagem> novoDialogo(Long idConversa) throws Exception{
		List<Dialogo> lista = new ArrayList<>();
		List<Mensagem> usadas = mensagemRepository.buscarPorNomeConversa("novodialogo", idConversa);
		String cond = montarCondRes(usadas);
		List<Mensagem> msgs = new ArrayList<>();
		if(cond.equals("")) {
			lista = dialogoRepository.buscarUltimosPorTipo("novodialogo");
		}else {
			String sql = "select d from Dialogo d where d.tipo = :tipo and d.mensagem not in ( " + cond + " )";
			Query query = entity.createQuery(sql);
			query.setParameter("tipo", "novodialogo");
			lista = query.getResultList();
		}
		if(lista == null) {
			return gravaMensagens(semDialogo(idConversa));
		}else if(lista.size() == 0) {
			return gravaMensagens(semDialogo(idConversa));
		}
		Dialogo dialogo = updateDialogo(sortearDialogo(lista));
		Mensagem msg = new Mensagem();
		msg.setIdConversa(idConversa);
		msg.setRes(dialogo.getMensagem());
		msg.setTipo("boot");
		msg.setName("novodialogo");
		msgs.add(msg);
		return gravaMensagens(msgs);
	}
	
	public List<Mensagem> semDialogo(Long id){
		List<Mensagem> lista = new ArrayList<>();
		Mensagem msg = new Mensagem();
		msg.setIdConversa(id);
		msg.setRes("No que posso ser útil");
		msg.setName("ajuda");
		msg.setTipo("boot");
		lista.add(msg);
		return lista;
	}
	
	public Dialogo sortearDialogo(List<Dialogo> lista) {
		Random gerador = new Random();
		int qtd = gerador.nextInt(50);
		int t = lista.size() - 1;
		int posicao = 0;
		for(int i = 0;i < qtd;i++) {
			if(i > t) {
				posicao = 0;
			}else {
				posicao++;
			}
			
		}
		return lista.get(posicao);
	}
	
	private String montarCondRes(List<Mensagem> usadas) {
		String cond = "";
		for(int i = 0;i < usadas.size();i++) {
			if(i == usadas.size() - 1) { //ultimo
				cond += "'" + usadas.get(i).getRes() + "'";
			}else {
				cond += "'" + usadas.get(i).getRes() + "', ";
			}
		}
		return cond;
	}

	public Dialogo updateDialogo(Dialogo dialogo) throws Exception{
		dialogo.setDataUtilizacao(new Date());
		return dialogoRepository.save(dialogo);
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
	
	public Mensagem semResposta(Long id) throws Exception{
		Mensagem msg = new Mensagem();
		msg.setRes("Desculpe minha ignorancia, mas eu estou sem resposta!");
		msg.setTipo("boot");
		msg.setIdConversa(id);
		return gravaMensagem(msg);
	}
	
	public List<Mensagem> erroMensagem(Mensagem msg) throws Exception{
		if(msg.getId() == null) {
			gravaMensagem(msg);
		}
		List<Mensagem> lista = new ArrayList<>();
		lista.add(semResposta(msg.getIdConversa()));
		lista.add(novoDialogo(msg.getIdConversa()).get(0));
		return lista;
	}
	
	public List<Mensagem> relatarProblema(){
		List<Mensagem> lista = new ArrayList<>();
		Mensagem msg = new Mensagem();
		msg.setRes("Desculpe, mas temporariamente estamos com problema");
		msg.setTipo("boot");
		lista.add(msg);
		return lista;
	}
}
