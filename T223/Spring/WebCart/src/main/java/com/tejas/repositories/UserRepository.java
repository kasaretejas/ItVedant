package com.tejas.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tejas.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	//if user with given username is present then bring it.
	//useful while login.
	Optional<User> findByUsername(String userName);
	
	//if user with given username is exits then we can not register that user.
	boolean existsByUsername(String userName);
}
