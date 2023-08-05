package com.fit.se.OrderService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.fit.se.OrderService.model.Order;

import javax.transaction.Transactional;

public interface OrderRepository extends JpaRepository<Order, Long>{

	List<Order> findOrderByStatus(int status);

	@Transactional
	@Modifying
	@Query(value = "UPDATE orders SET status = ?1 WHERE id = ?2", nativeQuery = true)
	void updateOrderStatus(int status, Long id);
}
