package com.engsoftware.r2d2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.engsoftware.r2d2.model.Remover;

public interface RemoveRepository extends JpaRepository<Remover, Long> {

}
