package com.engsoftware.r2d2.service;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engsoftware.r2d2.model.Tags;
import com.engsoftware.r2d2.repository.TagsRepository;

@Service
public class TagService {
	
	@Autowired
	TagsRepository tagRepository;
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Tags> buscar() {
		String sql = "select * from tags";
		Query query = em.createNativeQuery(sql);
		return query.getResultList();
	}
}
