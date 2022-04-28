package com.example.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component 
public class Greeting {

	
	private String content;

	public Greeting(String content) {
		super();
		this.content = content;
	}	
	

	public Greeting() {
		super();
	}




	public String getContent() {
		return content;
	}

}
