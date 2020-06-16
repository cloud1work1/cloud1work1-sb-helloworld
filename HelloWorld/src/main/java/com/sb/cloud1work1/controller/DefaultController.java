package com.sb.cloud1work1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {
	
	@GetMapping("/")
	public String helloWorld() {
		return "Hello World !!, Cloud1Work1";
	}

}
