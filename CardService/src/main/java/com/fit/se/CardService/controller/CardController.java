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

import com.fit.se.CardService.model.Card;
import com.fit.se.CardService.service.CardService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/api/v1/card")
public class CardController {
//    private static Logger logger = LogManager.getLogger(ChuyenBayController.class);
    private static Gson gson = new Gson();
    @Autowired
    private CardService cardService;

    @GetMapping("/")
    public String getAllCard() {
        List<Card> cards = cardService.getAll();
//        logger.info("controller - getChuyenBayDiDaLat:" + dsChuyenBay.size());
        String message = "Danh sách tất cả các thiệp loại card";
        if (cards.size() == 0) {
            message = "Lỗi hệ thống. Liên hệ bộ phận chăm sóc khách hàng";
        }
        Map<String, Object> res = new HashMap<>();
        res.put("message", message);
        res.put("ds_chuyen_bay", cards);
        return gson.toJson(res);
    }
    
    @PostMapping("/delete/{id}")
    public String deleteCard(@PathVariable Long id) {
    	String message = null;
    	int isDelete = 0;
    	isDelete = cardService.delete(id);
    	if(isDelete ==1) {
    		message = "Xoá thành công" ;
    	}
    	else {
    		message = "Xoá thất bại";
    	}
    	Map<String, Object> res = new HashMap<>();
    	res.put("message", message);
    	res.put("status", isDelete);
    	return gson.toJson(res);
    	}

    
}