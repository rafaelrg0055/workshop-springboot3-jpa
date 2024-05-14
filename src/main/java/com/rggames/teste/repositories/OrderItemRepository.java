package com.rggames.teste.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rggames.teste.entities.OrderItem;
import com.rggames.teste.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{
	
	

}
