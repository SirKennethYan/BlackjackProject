package com.skilldistillery.blackjack.entities;

public class Player {

	private Hand hand = new BlackjackHand();

	public Player() {
		super();
	}

	public Player(Hand hand) {
		super();
		this.hand = hand;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public void playerHandValue(Hand hand) {
		int value = 0;
		for (Card card : this.hand.getCards()) {
			System.out.println(card);
			value += card.getValue();
		}
		System.out.println("Total value: " + value);
	}
	
	

}
