package com.skilldistillery.blackjack.entities;

public class Dealer extends Player {
	private Deck deck;
	private Hand hand;

	public Dealer() {
		super();

	}

	public Dealer(Deck deck, Hand hand) {
		super();
		this.deck = deck;
		this.hand = hand;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public Card dealCard() {
		return deck.dealCard();
	}

	public void shuffle(Deck deck) {
		deck.shuffleDeck();
	}

	public int dealerCardValue() {
		int value = 0;
		for (int i = 1; i < hand.getCards().size(); i++) {
			hand.getCards().get(i);
			value += hand.getCards().get(i).getValue();
		}
		return value;
	}

	public int hiddenDealerCardValue() {
		int value = 0;
		for (int i = 0; i < hand.getCards().size() - 1; i++) {
			System.out.println(hand.getCards().get(i));
			value = hand.getCards().get(i).getValue();
		}
		return value;
	}

}
