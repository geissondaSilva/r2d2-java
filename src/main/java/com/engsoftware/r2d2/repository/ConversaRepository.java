package com.engsoftware.r2d2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.engsoftware.r2d2.model.Conversa;

@Repository
public interface ConversaRepository extends JpaRepository<Conversa, Long>{
	
}
