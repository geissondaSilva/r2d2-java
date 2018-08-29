package com.engsoftware.r2d2.controler;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.engsoftware.r2d2.model.Mensagem;
import com.engsoftware.r2d2.service.MensagemService;

@RestController
@RequestMapping("api/r2d2/mensagem")
public class MensagemControler {
	
	@Autowired
	private MensagemService mensagemService;
	
	@PostMapping("novamensagem/{idconversa}")
	public List<Mensagem> novaMensagem(@RequestBody Mensagem msg, @PathParam("idconversa") Long idConversa){
		try {
			return mensagemService.novaMensagem(msg, null, idConversa);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
