package com.generation.helloword.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Aqui é a class controller
@RequestMapping("/helloword") // tudo que tiver o (/...) é um endpoint
public class HelloController {
	
	
	@GetMapping //entrar no hello word e retornar ... 
	public String hello() {
		return "Testanto o primeiro projeto com Spring!";
				
		
		
		
	}

}
