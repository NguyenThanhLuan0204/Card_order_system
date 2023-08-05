package com.fit.se.OrderService.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fit.se.OrderService.dto.CardDTO;
import com.fit.se.OrderService.model.Card;
import com.fit.se.OrderService.model.Order;
import com.fit.se.OrderService.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private OrderRepository repo;

	private static final String URL_CARDSERVICE = "http://CARDSERVICE/api/v1/card/";

	private Map<String, Order> ordersMap = new HashMap<>();
	private Map<String, Card> cardsMap = new HashMap<>();

	@Override
	public Order createOrder(Order order) throws JsonMappingException, JsonProcessingException {
		try {
			String test = restTemplate.getForObject(URL_CARDSERVICE + order.getIdCard().toString().trim(),
					String.class);
			CardDTO cardDTO = mapper.readValue(test, CardDTO.class);
			if (order.getQuantity() <= cardDTO.getQuantityStorage()) {
				cardDTO.setQuantityStorage(cardDTO.getQuantityStorage() - order.getQuantity());

//        		HttpHeaders headers = new HttpHeaders();
//        		headers.setContentType(MediaType.APPLICATION_JSON);
//        		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
//        		map.add("id", cardDTO.getId().toString());
//        		map.add("decription", cardDTO.getDecription().toString());
//        		map.add("type", cardDTO.getType().toString());
//        		map.add("nameCard", cardDTO.getNameCard().toString());
//        		map.add("status", cardDTO.getStatus().toString());
//        		map.add("img", cardDTO.getImg());
//        		map.add("price", cardDTO.getPrice().toString());
//        		map.add("validQuanlity", cardDTO.getQuantityStorage().toString());

//        		HttpEntity<MultiValueMap<String,String>> rq = new HttpEntity<MultiValueMap<String,String>>(map,headers);
				String response = restTemplate.postForObject(URL_CARDSERVICE + "update", cardDTO, String.class);

				return repo.save(order);
			}
		} catch (Exception e) {
			return null;
		}
		return null;
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

	@Override
	public List<Order> getAll() {
		return repo.findAll();
	}
}
