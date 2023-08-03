package com.fit.se.CardService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fit.se.CardService.model.Card;

public interface CardRepository extends JpaRepository<Card, Long> {
	@Override
	<S extends Card> List<S> saveAll(Iterable<S> entities);


}