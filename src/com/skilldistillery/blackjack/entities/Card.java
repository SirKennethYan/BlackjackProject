package com.skilldistillery.blackjack.entities;

import java.util.Objects;

//	Create a class called Card.
public class Card {
//	Card has a Suit and Rank. 
	private Rank rank;
	private Suit suit;
	private int value;

	public Card() {
	}

//	Set these in the constructor.
	public Card(Suit st, Rank rk) {
		super();
		suit = st;
		rank = rk;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

//	Add a toString which says rank + " of " + suit.
	@Override
	public String toString() {
		return "" + rank + suit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(rank, suit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return rank == other.rank && suit == other.suit;
	}
	
	public int getValue() {
		return value;
	}
	
	public int getPlayerHandValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

}

