package com.main.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.main.Controller.JokeController;
import com.main.model.Joke;

class JokeControllerTest {

	static JokeController controller = null;
	static List<Joke> list = null;
	static Joke[] jokeArray = null;
	
	@BeforeAll
	public static void setUp() throws URISyntaxException {
		list = new ArrayList<Joke>();
		controller = mock(JokeController.class);
		list.add(new Joke("testTypeOne","testJokeOne"));
		list.add(new Joke("testTypeTwo","testJokeTwo"));
		list.add(new Joke("testTypeThree","testJokeThree"));
		
		when(controller.getJokes()).thenReturn(list);
		when(controller.getJoke(1)).thenReturn(new Joke("testType","testJoke"));
		
	}
	@Test
	void getJokeTest() throws URISyntaxException {
		
		assertEquals(new Joke("testType","testJoke"),controller.getJoke(1));
		verify(controller).getJoke(1);
	}
	
	@Test
	void getJokesTest() {
		
		
		List<Joke> comparedList = new ArrayList<>();
		comparedList.add(new Joke("testTypeOne","testJokeOne"));
		comparedList.add(new Joke("testTypeTwo","testJokeTwo"));
		comparedList.add(new Joke("testTypeThree","testJokeThree"));
		assertEquals(comparedList,controller.getJokes());
		
	}
	
	

}
