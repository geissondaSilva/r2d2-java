package com.engsoftware.r2d2.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.engsoftware.r2d2.result.PerguntaResult;
import com.engsoftware.r2d2.service.PerguntaService;

@RestController
@RequestMapping("api/r2d2/pergunta")
public class PerguntaControler {
	
	@Autowired
	PerguntaService perguntaService;
	
	@PostMapping
	public ResponseEntity<PerguntaResult> salvar(@RequestBody() PerguntaResult pergunta){
		try {
			pergunta = perguntaService.salvar(pergunta);
			return ResponseEntity.ok(pergunta);
		}catch (Exception e) {
			return new ResponseEntity<PerguntaResult>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
