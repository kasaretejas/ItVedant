package com.tejas.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejas.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
	//to get user details by email while login
	Optional<User> findByEmail(String email);
	//to check if email already exist while registration
	boolean existsByEmail(String email);
}
