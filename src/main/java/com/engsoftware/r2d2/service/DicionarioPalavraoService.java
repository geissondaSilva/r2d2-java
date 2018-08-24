package com.engsoftware.r2d2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engsoftware.r2d2.model.DicionarioPalavrao;
import com.engsoftware.r2d2.repository.DicionarioPalaraoRepository;

@Service
public class DicionarioPalavraoService {
	
	@Autowired
	DicionarioPalaraoRepository dicionarioPalavraRepository;
	
	public DicionarioPalavrao cadastrarPalavrao(DicionarioPalavrao palavrao) throws Exception{
		return dicionarioPalavraRepository.save(palavrao);
	}
}
