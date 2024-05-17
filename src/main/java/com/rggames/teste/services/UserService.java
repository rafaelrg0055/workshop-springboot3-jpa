package com.rggames.teste.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rggames.teste.entities.User;
import com.rggames.teste.repositories.UserRepository;
import com.rggames.teste.services.exceptions.ResourceNotFoundException;

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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	
	// salvar no BD um dado usuário
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {   // não vai atualizar "id" nem "senha"
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
