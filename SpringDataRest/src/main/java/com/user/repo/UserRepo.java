package com.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.model.User;

public interface UserRepo extends JpaRepository<User,Long>  {

}
