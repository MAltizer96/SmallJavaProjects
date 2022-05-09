package com.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

import com.user.model.User;

@RepositoryRestResource(collectionResourceRel="users",path="users")
public interface UserRepo extends JpaRepository<User,Integer> {
	
	public User findByUsername(@RequestParam("username") String username);
}

