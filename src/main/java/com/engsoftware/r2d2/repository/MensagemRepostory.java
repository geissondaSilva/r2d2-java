package com.engsoftware.r2d2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.engsoftware.r2d2.model.Mensagem;

public interface MensagemRepostory extends JpaRepository<Mensagem, Long>{
	
	@Query("select m from Mensagem m where m.idConversa = :id and m.name = :name")
	public List<Mensagem> buscarPorNomeConversa(@Param("name")String name, @Param("id")Long idConversa);
}
