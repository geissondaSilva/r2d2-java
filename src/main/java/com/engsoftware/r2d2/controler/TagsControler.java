package com.engsoftware.r2d2.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.engsoftware.r2d2.model.Tags;
import com.engsoftware.r2d2.service.TagService;

@RestController()
@RequestMapping("api/r2d2/tags")
public class TagsControler {
	
	@Autowired
	private TagService tagService;
	
	@GetMapping
	public List<Tags> buscar(){
		return tagService.buscar();
	}
}
