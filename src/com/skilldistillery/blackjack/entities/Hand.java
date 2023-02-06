package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	protected List<Card> cards;

	public Hand() {
		cards = new ArrayList<Card>();
	}

	public Card addCard(Card card) {
		cards.add(card);
		return card;
	}

	public void clear() {
		cards.clear();
	}

	public int getHandValue() {
		int totalValue = 0;
		return totalValue;
	}

	public List<Card> getCards() {
		return cards;
	}

	@Override
	public String toString() {
		return "Hand [cards=" + cards + "]";
	}
	
}
