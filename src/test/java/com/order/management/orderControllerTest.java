package com.order.management;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.management.controller.OrderController;
import com.order.management.entity.Order;
import com.order.management.service.OrderService;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private OrderService orderService;
	
	private Order order;
	
	private List<Order> orderList;
	
	@InjectMocks
	private OrderController orderController;
	
	@BeforeEach
	public void setup()
	{
		order=new Order(1,"soap",11,new Date());
		 mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
	}
	
	@AfterEach
	public void teardown()
	{
		order=null;
	}
	
	@Test
	void postMappingOfOrderTest() throws Exception {
		when(orderService.addorder(any())).thenReturn(order);
		  mockMvc.perform(post("/order").
	                contentType(MediaType.APPLICATION_JSON).
	                content(asJsonString(order))).
	                andExpect(status().isOk());
	        verify(orderService,times(1)).addorder(any());
	}
	
	
	@Test
	void getAllOrderTest() throws Exception
	{
		when(orderService.listall()).thenReturn(orderList);
        mockMvc.perform(MockMvcRequestBuilders.get("/order").
                contentType(MediaType.APPLICATION_JSON).
                        content(asJsonString(order))).
                andDo(MockMvcResultHandlers.print());
        verify(orderService).listall();
        verify(orderService,times(1)).listall();
	}
	

	
	

	public static String asJsonString(final Object obj){
        try{
            return new ObjectMapper().writeValueAsString(obj);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
