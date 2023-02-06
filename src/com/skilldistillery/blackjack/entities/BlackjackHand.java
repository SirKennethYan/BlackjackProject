package com.skilldistillery.blackjack.entities;

public class BlackjackHand extends Hand {

	public BlackjackHand() {
	}

	@Override
	public int getHandValue() {
//	What is the value of the total cards in your hand?
		int totalValue = 0;
		for (Card card : this.cards) {
			totalValue += card.getValue();
		}
		return totalValue;
	}

//	Does the value of your hand equal 21?
	public boolean isBlackjack() {
		boolean result = false;
		if (getHandValue() == 21) {
			result = true;
		}
		return result;

	}

//	Does the value of your hand equal 22 or above?
	public boolean isBust() {
		boolean result = false;
		if (getHandValue() > 21) {
			result = true;
		}
		return result;
	}

}