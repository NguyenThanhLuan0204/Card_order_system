package com.fit.se.OrderService.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fit.se.OrderService.service.OrderService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fit.se.OrderService.model.Order;
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    private static Gson gson = new Gson();
    @Autowired
    private OrderService orderService;
    @Autowired
    private ObjectMapper mapper;

    @PostMapping("/create")
    public String createOrder(@RequestBody Order order) throws JsonProcessingException {
        Order createdOrder = orderService.createOrder(order);
        if(createdOrder!=null) {
        	return mapper.writeValueAsString(createdOrder);
        }
        return "Tạo hóa đơn thất bại";
    }
    @PostMapping("/cancel/{id}")
    public String cancelOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    	return "ok";
    }
    @GetMapping("/")
    public String getAll() throws JsonProcessingException {
    	return mapper.writeValueAsString(orderService.getAll());
    }
    
    public String deleteOrder(@PathVariable Long id) {
    	orderService.deleteOrder(id);
    	return "delete success";
    }
    
    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable String orderId) {
        Order order = orderService.getOrderById(orderId);
        if (order != null) {
            return order;
        } else {
            return null;
        }
    }
}
