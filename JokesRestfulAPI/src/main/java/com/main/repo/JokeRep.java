package com.main.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.main.model.Joke;

@RepositoryRestResource(collectionResourceRel = "joke", path = "jokes")

public interface JokeRep extends JpaRepository<Joke, Long> {
	
	public Joke[] getByType(@Param("type")String type);
	public List<Joke>getAllByType(@Param("type")String type);

}
