package com.fit.se.CardService.service;

import java.util.List;
import java.util.Optional;

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
	public Long delete(Long id) {
		try {
			cardRepository.deleteById(id);
		}catch (Exception e) {
			return -1L;
		}
		return id;
	}

	@Override
	public Card getCardById(Long id) {
		Optional<Card> card = cardRepository.findById(id);
		return card.isPresent() ? card.get() : null;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Card update(Card card) {
		Card cardTmp = cardRepository.getById(card.getId());
		return cardRepository.save(cardTmp);
	}

}