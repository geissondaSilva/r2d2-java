package com.engsoftware.r2d2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.engsoftware.r2d2.model.Pergunta;

public interface PerguntaRepository extends JpaRepository<Pergunta, Long>{

	@Query("select p.* from pergunta p where p.tipo = 'bemvindo' order by p.sequence")
	public List<Pergunta> buscarInicioConversa();
}
