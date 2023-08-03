package com.fit.se.CardService.service;


import java.util.List;

import com.fit.se.CardService.model.Card;


public interface CardService {

	List<Card> getAll();
    void save(List<Card> dsChuyenBay);
    int delete(Long id);
}