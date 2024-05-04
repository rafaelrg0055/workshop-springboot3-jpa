package com.rggames.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rggames.teste.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
	

}
