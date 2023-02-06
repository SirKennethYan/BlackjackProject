package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//	Create a class Deck. 
public class Deck {
	private int value;
//	It will hold a List of Cards.
	private List<Card> deck = new ArrayList<>();

//	In the constructor, initialize the List with all 52 cards.
	public Deck() {
		Rank[] ranks = Rank.values();
		Suit[] suits = Suit.values();

		for (Suit suit : suits) {
			for (Rank rank : ranks) {
				Card card = new Card(suit, rank);
				deck.add(card);
			}
		}
	}

//	Add a method shuffle to shuffle the deck.
	public void shuffleDeck() {
		Collections.shuffle(deck);

	}

//	Add a method dealCard that removes a Card from the deck.
	public Card dealCard() {
		return deck.remove(0);
	}

//	Add a method checkDeckSize which returns the number of cards still in the deck.
	public int checkDeckSize() {
		return deck.size();
	}

	public void setValue(int value) {
		this.value = value;
	}

	public List<Card> getDeck() {
		return deck;
	}

	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}

	
}
