package com.engsoftware.r2d2.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.engsoftware.r2d2.model.Conversa;
import com.engsoftware.r2d2.service.ConversaService;

@RestController
@RequestMapping("api/r2d2/conversa")
public class ConversaControler {
	
	@Autowired
	ConversaService conversaService;
	
	@CrossOrigin
	@PostMapping("/novaconversa/{tipo}")
	public Conversa novaConversa(@RequestBody Conversa conversa, @PathVariable("tipo") String tipo) {
		try {
			conversa = conversaService.novaConversa(conversa, tipo);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return conversa;
	}
}
