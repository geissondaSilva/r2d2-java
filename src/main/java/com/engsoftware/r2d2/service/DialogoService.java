package com.engsoftware.r2d2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engsoftware.r2d2.model.Dialogo;
import com.engsoftware.r2d2.model.Dicionario;
import com.engsoftware.r2d2.repository.DialogoRepository;
import com.engsoftware.r2d2.repository.DicionarioRepository;

@Service
public class DialogoService {
	
	@Autowired
	DialogoRepository  dialogoRepository;
	
	@Autowired
	DicionarioRepository dicionarioRepository;
	
	public Dialogo salvarNovoDialogo(Dialogo dialogo) throws Exception{
		Dialogo novo = dialogoRepository.save(dialogo);
		List<Dicionario> lista = new ArrayList<>();
		for(Dicionario dic : dialogo.getDicionario()) {
			dic.setIdDialogo(novo.getId());
			dic = dicionarioRepository.save(dic);
			lista.add(dic);
		}
		novo.setDicionario(lista);
		return novo;
	}
}
