package com.engsoftware.r2d2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.engsoftware.r2d2.repository.TagsRepository;

@Service
public class TagService {
	
	@Autowired
	TagsRepository tagRepository;
}
