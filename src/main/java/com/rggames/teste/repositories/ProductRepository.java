package com.rggames.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rggames.teste.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	

}
