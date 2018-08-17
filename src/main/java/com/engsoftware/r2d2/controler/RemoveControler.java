package com.engsoftware.r2d2.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.engsoftware.r2d2.model.Remover;
import com.engsoftware.r2d2.repository.RemoveRepository;

@RestController
@RequestMapping("api/r2d2/remover")
public class RemoveControler {
	
	@Autowired
	RemoveRepository removeRepository;
	
	@PostMapping
	public Remover save(@RequestBody Remover remover) {
		return removeRepository.save(remover);
	}
}
