package com.engsoftware.r2d2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engsoftware.r2d2.model.Mensagem;
import com.engsoftware.r2d2.repository.MensagemRepostory;

@Service
public class MensagemService {
	
	@Autowired
	MensagemRepostory mensagemRepository;
	
	public List<Mensagem> novaMensagem(){
		return null;
	}
}
