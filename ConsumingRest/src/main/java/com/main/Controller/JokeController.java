package com.main.Controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.model.Joke;

import com.main.model.Response;

public class JokeController {

	public List<Joke> getJokesArray(RestTemplate restTemplate) throws URISyntaxException {
		URI uri = new URI("http://localhost:8080/jokes/search/getByType?type=clean");
		ResponseEntity<Joke[]> responseEntity = restTemplate.getForEntity(uri, Joke[].class);
		Joke[] jokeArray = responseEntity.getBody();
		
		List<Joke> list = new ArrayList<Joke>();
		for(Joke joke : jokeArray) {
			list.add(joke);
		}
		return list;
	}
	
	//when using this request the json was returning with a _embedded which is part of HAL format see https://stackoverflow.com/questions/27405637/meaning-and-usage-of-embedded-in-hateoas
	public List<Joke>getJokes(RestTemplate restTemplate){
		Response response = restTemplate.exchange("http://localhost:8080/jokes/search/getAllByType?type=clean", HttpMethod.GET,null,new ParameterizedTypeReference<Response>() {}).getBody();
		List<Joke> list = response.getEmbedded().getJokes();			
		return list;
		
	}
	
	
	

	public Joke getJoke(int jokeIDNumber, RestTemplate restTemplate) throws URISyntaxException {
		URI uri = new URI("http://localhost:8080/jokes/" + jokeIDNumber);
		ObjectMapper mapper = new ObjectMapper();

		
		Joke joke = restTemplate.getForObject(uri, Joke.class);
		return joke;
	}
}
