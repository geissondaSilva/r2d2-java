package com.engsoftware.r2d2.controler;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.engsoftware.r2d2.model.Pergunta;
import com.engsoftware.r2d2.repository.PerguntaRepository;

@RestController
@RequestMapping("api/r2d2/pergunta")
public class PerguntaControler {
	
	
	private PerguntaRepository perguntaRepository;
	
	@PostMapping
	public Pergunta save(@RequestBody Pergunta pergunta) {
		return perguntaRepository.save(pergunta);
	}
}
