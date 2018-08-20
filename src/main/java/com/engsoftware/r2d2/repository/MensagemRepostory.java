package com.engsoftware.r2d2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.engsoftware.r2d2.model.Mensagem;

public interface MensagemRepostory extends JpaRepository<Mensagem, Long>{
	
}
