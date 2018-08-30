package com.engsoftware.r2d2.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.engsoftware.r2d2.model.Tags;

public interface TagsRepository extends JpaRepository<Tags, Long>{
	
	@Query("select t from Tags t where value = :value")
	public List<Tags> buscarTags(@Param("value") String value);
	
}
