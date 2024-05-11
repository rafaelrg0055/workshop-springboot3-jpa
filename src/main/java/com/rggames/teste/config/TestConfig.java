package com.rggames.teste.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rggames.teste.entities.Order;
import com.rggames.teste.entities.User;
import com.rggames.teste.entities.enums.OrderStatus;
import com.rggames.teste.repositories.OrderRepository;
import com.rggames.teste.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	// declarando uma dependencia
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	// database seeding (instanciando objetos e salvando no BD)
	@Override
	public void run(String... args) throws Exception {
		// tudo dentro do run será executado quando a aplicação for iniciada
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		userRepository.saveAll(Arrays.asList(u1 ,u2));
		orderRepository.saveAll(Arrays.asList(o1 ,o2, o3));
	}	
}


