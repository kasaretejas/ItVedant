package com.tejas.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejas.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
	//following jpa method required to get user object (which has role) to redirect
	//customer dashboard or vendor dashboard after successful LOGIN
	Optional<User> findByUserName(String username);
	
	//following jpa method required to check whether username is exists or not while REGISTERING
	//new user
	boolean existsByUserName(String username);

}
