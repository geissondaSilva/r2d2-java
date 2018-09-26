package com.engsoftware.r2d2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.engsoftware.r2d2.model.Dicionario;

@Repository
public interface DicionarioRepository extends JpaRepository<Dicionario, Long>{
	
	@Query("select d from Dicionario d where d.tipo = :tipo ")
	public List<Dicionario> buscarPorTipo(@Param("tipo") String tipo);
	
}
