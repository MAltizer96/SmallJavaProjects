package com.main.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.main.model.Joke;

@RepositoryRestResource(collectionResourceRel="jokes",path="jokes")
public interface JokeRep extends JpaRepository<Joke,Long>{
	@Query("SELECT u FROM Joke u WHERE type = ?1")
	List<Joke> getByType(String type);
	
	
	
	
}
