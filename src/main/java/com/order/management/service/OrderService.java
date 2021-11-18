package com.order.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.management.entity.Order;
import com.order.management.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderrep;

	public Order addorder(Order order) {

		return orderrep.save(order);
	}

	public List<Order> listall() {
		
		return orderrep.findAll();
	}

	public Order update(Order order, int id) {
		
		
		Optional<Order> orders = orderrep.findById(id);
		if(orders.isPresent()) {
			order.setId(id);
			return orderrep.save(order);
		}
		return null;
	}

	public void delete(int id) {
		
		Optional<Order> orders = orderrep.findById(id);
		if(orders.isPresent()) {
			
			orderrep.delete(orders.get());
		}
		
	}
	
	
	
	
}
