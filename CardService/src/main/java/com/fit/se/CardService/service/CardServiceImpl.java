package com.fit.se.CardService.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fit.se.CardService.model.Card;
import com.fit.se.CardService.repository.CardRepository;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepository cardRepository;

    @Override
    public List<Card> getAll() {
        return cardRepository.findAll();
    }

	@Override
	public void save(List<Card> dsChuyenBay) {
		cardRepository.saveAll(dsChuyenBay);
	}

	@Override
	public int delete(Long id) {
		@SuppressWarnings("deprecation")
		Card card = cardRepository.getOne(id);
		cardRepository.delete(card);
		return 1;
	}
	
	

}