package com.fit.se.OrderService.service;


import com.fit.se.OrderService.model.Card;
import com.fit.se.OrderService.model.Order;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class OrderServiceImpl implements OrderService {

    private Map<String, Order> ordersMap = new HashMap<>();
    private Map<String, Card> cardsMap = new HashMap<>();

    @Override
    public Order createOrder(Order order) {
        if (isCardValid(order.getIdCard().toString(), order.getQuanlity())) {
            // Reduce the quantity of the card
            Card card = cardsMap.get(order.getIdCard());
            card.setValidQuanlity(card.getValidQuanlity() - order.getQuanlity());
            cardsMap.put(card.getId(), card);

            // Save the order
            ordersMap.put(order.getId(), order);
            return order;
        } else {
            throw new IllegalArgumentException("Invalid card or insufficient quantity");
        }
    }

    @Override
    public Order getOrderById(String orderId) {
        return ordersMap.get(orderId);
    }

    @Override
    public int getQuantityValid(String cardId) {
        Card card = cardsMap.get(cardId);
        return (card != null) ? card.getValidQuanlity() : 0;
    }

    // Helper method to check if the card exists and has sufficient quantity
    private boolean isCardValid(String cardId, int requiredQuantity) {
        Card card = cardsMap.get(cardId);
        return (card != null && card.getValidQuanlity() >= requiredQuantity);
    }

    // Other implementations for additional methods can be added here

    // Helper method to add cards to the cardsMap (e.g., during initialization)
    public void addCard(Card card) {
        cardsMap.put(card.getId(), card);
    }
}
