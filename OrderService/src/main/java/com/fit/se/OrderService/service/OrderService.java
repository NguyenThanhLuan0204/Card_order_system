package com.fit.se.OrderService.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fit.se.OrderService.model.Order;


public interface OrderService {
    Order createOrder(Order order)throws JsonMappingException, JsonProcessingException;
    Order getOrderById(String orderId);
    int getQuantityValid(String cardId);
    List<Order> getAll();
    void deleteOrder(Long id);
    // Add other necessary methods for your API
}

