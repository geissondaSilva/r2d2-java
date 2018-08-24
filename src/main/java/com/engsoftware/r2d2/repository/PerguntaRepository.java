package com.engsoftware.r2d2.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.engsoftware.r2d2.model.Pergunta;

public interface PerguntaRepository extends JpaRepository<Pergunta, Long>{
	
	@Query("select p from Pergunta p where p.tipo = :tipo order by p.sequence")
	public List<Pergunta> buscarPerguntaPorTipo(@Param("tipo") String tipo);
	
	@Query("select p from Pergunta p where p.tipo = :tipo and p.assunto = :assunto order by p.sequence")
	public List<Pergunta> buscarPorTipoAssunto(@Param("tipo") String tipo, @Param("assunto") String assunto);
}
