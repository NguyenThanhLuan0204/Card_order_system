package com.fit.se.CardService.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fit.se.CardService.model.Card;
import com.fit.se.CardService.service.CardService;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/card")
public class CardController {
    private static final Logger LOGGER = LogManager.getLogger(CardController.class);

    private static Gson gson = new Gson();
    @Autowired
    private CardService cardService;
    @Autowired
    private ObjectMapper mapper;

    @GetMapping("/")
    public String getAllCard() throws JsonProcessingException {
        List<Card> cards = cardService.getAll();
        return mapper.writeValueAsString(cards);
    }
    
    @GetMapping("/{id}")
    public String getById(@PathVariable Long id) throws JsonProcessingException {
    	return mapper.writeValueAsString(cardService.getCardById(id));
    }
    
    @PostMapping("/save")
    public String save(@RequestBody Card card) throws JsonProcessingException {
    	
    	return mapper.writeValueAsString(cardService.saveOne(card));
    }
    
    @PostMapping(value="/update", consumes = "application/json", produces = "application/json")
    public String updateCard(@RequestBody Card card) throws JsonProcessingException {
    	LOGGER.info("{}" , mapper.writeValueAsString(card));
    	Card cardUpdate = cardService.update(card);
    	return mapper.writeValueAsString(cardUpdate);
    }
    
    @PostMapping("/delete/{id}")
    public String deleteCard(@PathVariable Long id) {
    	String message = null;
    	Long cardId;
    	int status;
		cardId = cardService.delete(id);
		Map<String, Object> res = new HashMap<>();
    	if(cardId != -1) {
    		status = 1 ;
    	}
    	else {
    		message = "Xóa thất bại";
    		status = -1;
    	}
    	res.put("status", status);
    	res.put("messageError", message);
    	res.put("cardId", cardId);
    	return gson.toJson(res);
    	}

    
}