package com.fit.se.OrderService.service;

import com.fit.se.OrderService.model.Order;


public interface OrderService {
    Order createOrder(Order order);
    Order getOrderById(String orderId);
    int getQuantityValid(String cardId);
    // Add other necessary methods for your API
}

