package com.main;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.Controller.JokeController;
import com.main.model.Joke;

@SpringBootApplication
public class ConsumingRestApplication {

	// used to send output to the log(console this time)
	private Logger log = LoggerFactory.getLogger(ConsumingRestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ConsumingRestApplication.class, args);
	}

	// uses the Jackson JSON processing library to process the incoming data
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		URI uri = new URI("http://localhost:8080/jokes/1");
		
		return args -> {

			JokeController controller = new JokeController();
			
			Joke joke = restTemplate.getForObject(uri, Joke.class);
			log.info(controller.getJoke(1, restTemplate).toString());
			log.info(controller.getJokesArray(restTemplate).toString());
			//log.info(controller.getJokes(restTemplate).toString());
			

	
		};
	}
}
