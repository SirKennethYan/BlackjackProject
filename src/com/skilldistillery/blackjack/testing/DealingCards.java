package com.skilldistillery.blackjack.testing;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Deck;

public class DealingCards {

	public static void main(String[] args) {
		// deal 5 cards from the deck, displaying each of the dealt cards
		DealingCards dealer = new DealingCards();
		dealer.deal();
	}

	public void deal() {
		Deck theDeck = new Deck();
		
		System.out.println(  theDeck.getDeck().size() );
		System.out.print("How many cards? ");
		
		Scanner scan = new Scanner(System.in);
		int numCards = scan.nextInt();
		scan.nextLine();
		
		theDeck.shuffle();
		
		for(int numCardsDealtSoFar = 0; numCardsDealtSoFar < numCards; numCardsDealtSoFar++) {
			Card aCard = theDeck.dealCard();
			System.out.println(theDeck.checkDeckSize()+ " cards left, just dealt: " + aCard);
		}
		
		scan.close();
	}
}