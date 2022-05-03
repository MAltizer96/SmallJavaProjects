package com.main.Controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.model.Joke;
import com.main.model.JokeList;

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
	
	public List<Joke>getJokes(RestTemplate restTemplate){
		//URI uri = new URI("http://localhost:8080/jokes/search/getByType?type=clean");
		String urlString = "http://localhost:8080/jokes/search/getAllByType?type=clean";
		
		ObjectMapper mapper = new ObjectMapper();
		ResponseEntity resposne = getResponseList(urlString,HttpMethod.GET,restTemplate);
		
		try {
			List<Joke>list = mapper.readValue(resposne.toString(), new TypeReference<List<Joke>>(){});
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	public ResponseEntity<List> getResponseList(String url,HttpMethod type,RestTemplate template){
		return template.exchange(url,type,null,List.class);
		
	}

	public Joke getJoke(int jokeIDNumber, RestTemplate restTemplate) throws URISyntaxException {
		URI uri = new URI("http://localhost:8080/jokes/" + jokeIDNumber);
		ObjectMapper mapper = new ObjectMapper();

		Joke joke = restTemplate.getForObject(uri, Joke.class);
		return joke;
	}
}
