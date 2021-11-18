package com.order.management.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="orderdetails")
public class Order {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private int orderid;
	private String name;
	private int amount;
	private Date orderdate;
	public int getId() {
		return orderid;
	}
	public void setId(int orderid) {
		this.orderid = orderid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public Order(int orderid, String name, int amount, Date localDate) {
		super();
		this.orderid = orderid;
		this.name = name;
		this.amount = amount;
		this.orderdate = localDate;
	}
	public Order() {
		super();
	}
	
}
