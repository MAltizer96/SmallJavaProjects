package com.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

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

	// runs the RestTemplate (also fetches our quotation)on startup
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) {
		return args -> {
			try {
				Joke joke = restTemplate.getForObject("http://localhost:8080/jokes/1", Joke.class);
				log.info(joke.toString());
			} catch (Exception e) {
				System.out.print("failed /n" +e);
			}

		};

	}

}
