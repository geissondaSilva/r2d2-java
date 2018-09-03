package com.engsoftware.r2d2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.engsoftware.r2d2.model.Resposta;

public interface RespostaRepository extends JpaRepository<Resposta, Long>{
	
	@Query("select r from Resposta r where r.idPergunta = :idpergunta")
	public Resposta buscarPorPergunta(@Param("idpergunta") Long idPergunta);
}
