package com.skilldistillery.blackjack.testing;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Deck;

public class DealingCards {

	public static void main(String[] args) {// main
		DealingCards dealer = new DealingCards();
		dealer.deal();
	}

//		Write a program to ask a user how many cards they want.
	public void deal() {
		Scanner scan = new Scanner(System.in);

		Deck theDeck = new Deck();

		System.out.print("How many cards do you want? ");

		try {
			int numCards = scan.nextInt();
			scan.nextLine();

			theDeck.shuffleDeck();
//		Deal the cards and display them on the screen. Also display the total value of all cards.
			for (int numCardsDealtSoFar = 0; numCardsDealtSoFar < numCards; numCardsDealtSoFar++) {// for
				Card aCard = theDeck.dealCard();
				System.out.println(theDeck.checkDeckSize() + " cards left, just dealt: " + aCard);
			}
		} catch (InputMismatchException e) {
			System.out.println("That is not a valid number of cards.");
		} finally {
			scan.close();

		}

	}

}