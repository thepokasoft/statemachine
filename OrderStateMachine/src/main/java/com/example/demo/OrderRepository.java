package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	//Order findOne(Long id);

}
