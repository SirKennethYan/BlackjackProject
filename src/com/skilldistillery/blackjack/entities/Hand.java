package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	protected List<Card> cards = new ArrayList<Card>();

	public Hand() {

	}

	public Card addCard(Card card) {
		cards.add(card);
		return card;
	}

	public void clear() {
		cards.clear();
	}

	public int getHandValue() {
		int totalHandValue = 0;
		return totalHandValue;
	}

	public List<Card> getCards() {
		return cards;
	}

	@Override
	public String toString() {
		return "Hand [cards=" + cards + "]";
	}
	
}
