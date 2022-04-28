package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Greeting;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

	private String returnStirng = "Hello, %s";
	@GetMapping
	public Greeting getGreeting(@RequestParam(value = "name", defaultValue = "world") String name) {
		
		return new Greeting(String.format(returnStirng, name));
	}
}
