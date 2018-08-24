package com.engsoftware.r2d2.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.engsoftware.r2d2.model.DicionarioPalavrao;
import com.engsoftware.r2d2.service.DicionarioPalavraoService;

@RestController
@RequestMapping("api/r2d2/dicionariopalavrao")
public class DicionarioPalavraoControler {
	
	@Autowired
	DicionarioPalavraoService dicionarioPalavraoService;
	
	@PostMapping
	public DicionarioPalavrao save(@RequestBody DicionarioPalavrao palavrao) {
		try {
			palavrao = dicionarioPalavraoService.cadastrarPalavrao(palavrao);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return palavrao;
	}
}
