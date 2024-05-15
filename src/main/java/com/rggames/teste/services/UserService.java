package com.rggames.teste.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rggames.teste.entities.User;
import com.rggames.teste.repositories.UserRepository;

@Service
public class UserService {
	
	// declarando uma dependencia
	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	// salvar no BD um dado usuário
	public User insert(User obj) {
		return repository.save(obj);
		
	}
	
}
