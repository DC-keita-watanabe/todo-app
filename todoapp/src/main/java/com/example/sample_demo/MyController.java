package com.example.sample_demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@Autowired TodoService todoService;
	
	@GetMapping("/api/tasks")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<Todo> showTodos(Model model) {
		List <Todo> todos = todoService.searchAll();
		return todos;
	}
}
