package com.order.management;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.order.management.entity.Order;
import com.order.management.repository.OrderRepository;
import com.order.management.service.OrderService;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class orderServiceTest {

	@Mock
	private OrderRepository orderRep;
	
	@Autowired
	@InjectMocks
	private OrderService orderSer;
	
	private Order order1;
	private Order order2;
	private List<Order> orderList;
	@BeforeEach
	public void setUp()
	{
		order1=new Order(1,"soap",11,new Date());
		order2=new Order(2,"brush",12,new Date());
	}
	
	@AfterEach
	public void tearDown()
	{
		order1=order2=null;
	}
	
	@Test
	void addOrderTest() {
		
		when(orderRep.save(any())).thenReturn(order1);
		orderSer.addorder(order1);
		verify(orderRep,times(1)).save(any());
	}
	
	@Test
	void getAllTest()
	{
		orderRep.saveAll(orderList);
		when(orderRep.findAll()).thenReturn(orderList);
		List<Order> expectedOrderList=orderSer.listall();
		assertEquals(expectedOrderList,orderList);
		verify(orderRep,times(1)).saveAll(orderList);
		verify(orderRep,times(1)).findAll();
	}
	
	

	

}
