package com.engsoftware.r2d2.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.engsoftware.r2d2.result.FuncionalidadeResult;
import com.engsoftware.r2d2.service.FuncionalidadeService;

@RestController
@RequestMapping("api/r2d2/funcionalidade")
public class FuncionalidadeControler {
	
	@Autowired
	FuncionalidadeService funcionalidadeService;
	
	@PostMapping
	public ResponseEntity<FuncionalidadeResult> salvar(@RequestBody() FuncionalidadeResult funcionalidade){
		try {
			funcionalidade = funcionalidadeService.salvar(funcionalidade);
			return ResponseEntity.ok(funcionalidade);
		}catch (Exception e) {
			return new ResponseEntity<FuncionalidadeResult>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
