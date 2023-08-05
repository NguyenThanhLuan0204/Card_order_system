package com.fit.se.OrderService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fit.se.OrderService.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

	List<Order> findOrderByStatus(int status);
	
	@Query(value="update orderservice set status = ?1 where id = ?2 ",nativeQuery = true)
	void updateOrderStatus(int status, Long id);
}
