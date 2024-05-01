package com.rggames.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rggames.teste.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	

}
