package com.engsoftware.r2d2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.engsoftware.r2d2.model.Dialogo;

public interface DialogoRepository extends JpaRepository<Dialogo, Long>{
	
	@Query("select d from Dialogo d where d.name = :name and d.tipo = :tipo")
	public List<Dialogo> buscarPorNameTipo(@Param("name") String name, @Param("tipo") String tipo);
	
	@Query("select d from Dialogo d where d.tipo = :tipo")
	public List<Dialogo> buscarPorTipo(@Param("tipo") String tipo);
}
