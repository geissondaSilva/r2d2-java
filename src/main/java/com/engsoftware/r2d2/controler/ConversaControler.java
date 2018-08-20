package com.engsoftware.r2d2.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.engsoftware.r2d2.dto.NovaConversaDto;
import com.engsoftware.r2d2.impl.ConversaImpl;

@RestController
@RequestMapping("api/r2d2/conversa")
public class ConversaControler {
	
	@Autowired
	ConversaImpl conversaService;
	
	@PostMapping("/novaconversa")
	public NovaConversaDto novaConversa(@RequestBody NovaConversaDto conversa) {
		NovaConversaDto nova = new NovaConversaDto();
		try {
			nova = conversaService.novaConversa(conversa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nova;
	}
}
