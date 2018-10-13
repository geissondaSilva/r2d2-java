package com.engsoftware.r2d2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engsoftware.r2d2.model.Acoes;
import com.engsoftware.r2d2.model.Funcionalidade;
import com.engsoftware.r2d2.model.Tags;
import com.engsoftware.r2d2.repository.AcaoRepository;
import com.engsoftware.r2d2.repository.FuncionalidadeRepository;
import com.engsoftware.r2d2.repository.TagsRepository;
import com.engsoftware.r2d2.result.FuncionalidadeResult;

@Service
public class FuncionalidadeService {
	
	@Autowired
	FuncionalidadeRepository funcionalidadeRepository;
	
	@Autowired
	AcaoRepository acaoRepository;
	
	@Autowired TagsRepository tagRepository;
	
	public FuncionalidadeResult salvar(FuncionalidadeResult funcionalidade) throws Exception {
		Acoes acao = acaoRepository.save(funcionalidade.getAcao());
		funcionalidade.setAcao(acao);
		Funcionalidade fun = new Funcionalidade();
		fun = funcionalidade.getFuncionalidade();
		fun.setIdAcao(funcionalidade.getAcao().getId());
		fun = funcionalidadeRepository.save(fun);
		funcionalidade.setFuncionalidade(fun);
		List<Tags> lista = funcionalidade.getTags();
		for(Tags tag : lista) {
			tag.setIdFuncionalidade(fun.getId());
			tag = tagRepository.save(tag);
		}
		funcionalidade.setTags(lista);
		return funcionalidade;
	}
}
