package com.engsoftware.r2d2.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.engsoftware.r2d2.model.RemovePergunta;
import com.engsoftware.r2d2.repository.RemovePerguntaRepository;

@RestController
@RequestMapping("api/r2d2/removepergunta")
public class RemovePerguntaControler {
	
	@Autowired
	RemovePerguntaRepository removePerguntaRepository;
	
	@PostMapping
	public RemovePergunta save(@RequestBody RemovePergunta removePergunta) {
		return removePerguntaRepository.save(removePergunta);
	}
}
