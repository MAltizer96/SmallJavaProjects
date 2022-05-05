package com.main.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JokeTest {

	Joke joke = null;
	
	@BeforeEach
	public void setUp(){
		joke = new Joke();
	}
	@Test
	void getAndSetIDTest() {		
		joke.setId(2);
		assertEquals(2,joke.getId());
	}
	
	@Test
	public void toStringTest() {
		joke.setId(2);
		joke.setJoke("test joke");
		joke.setType("testType");
		
		assertEquals("Joke [id=" + 2 + ", type=" + "testType" + ", joke=" + "test joke" + "]", joke.toString());
	}

}
