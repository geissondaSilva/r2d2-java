package com.engsoftware.r2d2.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.engsoftware.r2d2.model.Tags;
import com.engsoftware.r2d2.repository.TagsRepository;

@RestController()
@RequestMapping("api/r2d2/tags")
public class TagsControler {
	
	@Autowired
	TagsRepository tagsRepositoy;
	
	@PostMapping("all")
	public Tags cadastrar(@RequestBody Tags tags) {
		return tagsRepositoy.save(tags);
	}
	
	@GetMapping
	public List<Tags> buscarTodos(){
		return tagsRepositoy.findAll();	
	}
}
