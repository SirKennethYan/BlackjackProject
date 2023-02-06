package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.BlackjackHand;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Deck;
import com.skilldistillery.blackjack.entities.Player;

public class BlackJackApp {
	
	private Scanner scan = new Scanner(System.in);
	String userInput = scan.nextLine();
	private Deck theDeck = new Deck();
	private Dealer dealer;
	private Player player;
	
	public BlackJackApp() {
		this.dealer = new Dealer(theDeck, new BlackjackHand());
		this.player = new Player(new BlackjackHand());
	}
		
	public static void main(String[] args) {
		BlackJackApp bja = new BlackJackApp();
		bja.startApp();
	}

	public void startApp() {
		System.out.println("*********** Welcome ***********");
		System.out.println("*********             *********");
		System.out.println("*******                 *******");
		System.out.println("*****         To          *****");
		System.out.println("*******                 *******");
		System.out.println("*********             *********");
		System.out.println("********** Blackjack **********");
		System.out.println("******* (press any key) *******");
		scan.nextLine();
		continueApp() ;
	}//startApp

	private void continueApp()  {
		System.out.println("Press 1 to Play.");
		System.out.println("Press 2 to Quit.");

		if (userInput.equals("1")) {
			startGame(scan);
		} else if (userInput.equals("2")) {
			System.out.println("Goodbye.");
		} else {
			System.out.println("Invalid input. Choose either 1 or 2.");
			continueApp() ;
		}
	}// showMainMenu

	private void startGame(Scanner scan) {
		Dealer dealer = new Dealer(new Deck(), new BlackjackHand());
		Player player = new Player(new BlackjackHand());
		Deck theDeck = dealer.getDeck();

		while (theDeck.checkDeckSize() >= 10) {
			dealer.getHand().clear();
			dealer.getHand().clear();

////		Blackjack Time-line: 1
////		Player Press 1 to play.
////		Dealer: Shuffles deck and deals two cards to player + value of both cards.
			dealer.shuffle(theDeck);
			System.out.println("You are dealt " + player.getHand().addCard(dealer.dealCard()).toString());
			System.out.println("and a " + player.getHand().addCard(dealer.dealCard()).toString());
			System.out.println("Player hand total: " + player.getHand().getHandValue());
			System.out.println();

////		Blackjack Time-line: 2
////		Dealer: Deals two himself two cards, one face-up one face-down. Only face up card value is known.
			dealer.getHand().addCard(dealer.dealCard()).toString();
			System.out.println("Dealer deals two himself two cards, one face-up one face-down. ");
			System.out.println("Dealer is dealt: " + dealer.getHand().addCard(dealer.dealCard()).toString());
			System.out.println("Dealer hand total: " + dealer.hiddenDealerCardValue());
			System.out.println("Dealer hand total: " + dealer.dealerCardValue());
			System.out.println();

////		Blackjack Time-line: 3
////		Did Player or Dealer hit 21?
			if (dealer.getHand().getHandValue() == 21) {
				System.out.println("Dealer has a score of: " + dealer.getHand().getHandValue() + "Dealer Wins!!!");
			} else if (player.getHand().getHandValue() == 21) {
				System.out.println("Player has a score of: " + player.getHand().getHandValue() + "Player Wins!");
				System.out.println();
			} else {

////		Blackjack Time-line: 4
////		Player: 'Hit' or 'Stand'.
////		if(hit): Dealer deals one card to player face-up... then prompts, 'Hit' or 'Stand'?
////		Did Player or Dealer bust?
				while (true) {
					System.out.println("Press 1 to Hit or 2 to Stand? ");
					System.out.println();
					if (userInput.equals("1")) {
						System.out.println("You are dealt " + player.getHand().addCard(dealer.dealCard()).toString());
						System.out.println("Player hand total: " + player.getHand().getHandValue());

						if (player.getHand().getHandValue() > 21) {
							System.out.println("Bust!!! You lose. ");
							System.out.print("Another round? Press 1 for Yes or 2 for No ");

							if (userInput.equals("1")) {
								startGame(scan);
							}
						} else {
							continue;
						}
////		Blackjack Time-line: 5
////		if(stand): Dealer deals himself one card at a time until Dealer reaches 17.
////		Did Player or Dealer bust?
					} else if (userInput.equals("2")) {
						System.out.println("Dealer shows face down card: " + dealer.hiddenDealerCardValue());
						System.out.println("Dealer has a score of : " + dealer.getHand().getHandValue());
						while (true) {
							compareCards(player.getHand().getHandValue(), dealer.getHand().getHandValue());
							if (dealer.getHand().getHandValue() >= 17 && dealer.getHand().getHandValue() <= 21) {
								System.out.println("Dealer score is now: " + dealer.getHand().getHandValue());
								System.out.println();
								break;
							} else if (dealer.getHand().getHandValue() < 17) {

								while (dealer.getHand().getHandValue() < 17) {
									if (!(theDeck.checkDeckSize() >= 10)) {
										break;
									}
									System.out.println("Dealer is dealt: "
											+ dealer.getHand().addCard(dealer.dealCard()).toString());
									System.out.println("Dealer score is now: " + dealer.getHand().getHandValue());
									if (dealer.getHand().getHandValue() > 21) {
										System.out.println("Dealer: Bust!");
										System.out.println("Dealer loses this round.");
										System.out.println("Player wins!");
										break;

									}

								}
								compareCards(player.getHand().getHandValue(), dealer.getHand().getHandValue());
								playAnother(scan);
								break;
							} // else-if

						} // while-loop

					} // else-if

				} // while-loop

			} // else

		} // while-loop

	}// startGame

	public void compareCards(int player, int dealer) {
		String result = "";
		if (player == dealer) {
			result = "Push.";
		} else if (player > 21 || dealer >= player) {
			result = "Dealer wins!";
		} else if (dealer > 21 || player >= dealer) {
			result = "Player wins!";
		}
		System.out.println(result);
		System.out.print("Another round? Press 1 for Yes or 2 for No ");
		if (userInput.equals("1")) {
			startGame(scan);
		} else if (userInput.equals("2")) {
			System.out.println("Goodbye. ");
			System.out.println();
		}
	}// compareCards

	public void playAnother(Scanner scan) {
		System.out.print("Another round? Press 1 for Yes or 2 for No ");
		userInput = scan.nextLine();
		if (userInput.equals("1")) {
			startGame(scan);
		} else if (userInput.equals("2")) {
			System.out.println("Goodbye. ");
			System.out.println();
		}
		exitProgram();
	}// playAnother

	public void exitProgram() {
		System.out.println("Thank you for playing!");
		System.exit(0);
	}// exitProgram

}
