package com.engsoftware.r2d2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.engsoftware.r2d2.model.Pergunta;
import com.engsoftware.r2d2.model.Resposta;
import com.engsoftware.r2d2.model.Tags;
import com.engsoftware.r2d2.repository.PerguntaRepository;
import com.engsoftware.r2d2.repository.RespostaRepository;
import com.engsoftware.r2d2.repository.TagsRepository;
import com.engsoftware.r2d2.result.PerguntaResult;

@Service
public class PerguntaService {
	
	@Autowired
	PerguntaRepository perguntaRepository;
	
	@Autowired
	TagsRepository tagRepository;
	
	@Autowired
	RespostaRepository respostaRepository;
	
	@Transactional
	public PerguntaResult salvar(PerguntaResult pergunta) throws Exception {
		Pergunta per = perguntaRepository.save(pergunta.getPergunta());
		pergunta.setPergunta(per);
		for(Tags tag : pergunta.getTags()) {
			tag.setIdPergunta(per.getId());
			tag = tagRepository.save(tag);
		}
		Resposta res = pergunta.getResposta();
		res.setIdPergunta(per.getId());
		pergunta.setResposta(respostaRepository.save(res));
		return pergunta;
	}
}
