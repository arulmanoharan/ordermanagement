package com.order.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.order.management.entity.Order;
import com.order.management.service.OrderService;


@RestController
public class OrderController {

	@Autowired
	private OrderService orderservice;
	
	@PostMapping("/order")
	public Order postorder(@RequestBody Order order) {
		return orderservice.addorder(order);
	}
	@GetMapping("/order")
	public List<Order> getorder(){
		return orderservice.listall();
	}
	
	@PutMapping("/orderupdate/{id}")
	public Order putorder(@RequestBody Order order,@PathVariable int id){
	 
	return orderservice.update(order,id);
	}
	@DeleteMapping("orderdelete/{id}")
	public void deleteorder(@PathVariable int id) {
		orderservice.delete(id);
	}
}
