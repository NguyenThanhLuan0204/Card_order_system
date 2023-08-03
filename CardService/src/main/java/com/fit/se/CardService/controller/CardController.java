package com.fit.se.CardService.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fit.se.CardService.model.Card;
import com.fit.se.CardService.service.CardService;
import com.google.gson.Gson;

import lombok.experimental.PackagePrivate;

@RestController
@RequestMapping("/api/v1/card")
public class CardController {
//    private static Logger logger = LogManager.getLogger(ChuyenBayController.class);
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
    
    @PostMapping("/update/{id}")
    public String updateCard(@PathVariable Long id) throws JsonProcessingException {
    	Card card = cardService.getCardById(id);
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