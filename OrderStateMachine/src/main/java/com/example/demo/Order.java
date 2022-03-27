package com.example.demo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.example.demo.OrderStates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "ORDERS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {


	@Id
	@GeneratedValue
	private Long id;
	private Date datetime;

	private String state;

	public Order(Date d, OrderStates os) {
		this.datetime = d;
		this.setOrderState(os);
	}

	public OrderStates getOrderState() {
		return OrderStates.valueOf(this.state);
	}

	public void setOrderState(OrderStates s) {
		this.state = s.name();
	}
}
