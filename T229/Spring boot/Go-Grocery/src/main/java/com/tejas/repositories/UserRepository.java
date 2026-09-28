package com.tejas.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejas.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
	//after login, collect user object
	Optional<User> findByUsername(String username); //if username present then it will give object
	
	//while registering, to check if username already exists
	boolean existsByUsername(String username); //if username is present then return true otherwise false
	
}
