package com.engsoftware.r2d2.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.engsoftware.r2d2.model.Dialogo;
import com.engsoftware.r2d2.service.DialogoService;


@RestController
@RequestMapping("api/r2d2/dialogo")
public class DialogoControler {
	
	@Autowired
	DialogoService dialogoService;
	
	@PostMapping("novodialogo")
	public ResponseEntity<Dialogo> salvarNovoDialogo(@RequestBody() Dialogo dialogo){
		try {
			dialogo = dialogoService.salvarNovoDialogo(dialogo);
			return ResponseEntity.ok(dialogo);
		}catch (Exception e) {
			return new ResponseEntity<Dialogo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
