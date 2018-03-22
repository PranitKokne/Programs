/**
 * Purpose :The program initialize a deck of cards having suit and rank.
 * 			then it shuffles the deck using the random class.
 * 			it distributes 9 cards to 4 players and print the cards in 
 * 			2 dimensional form.
 * 
 * @author Pranit_Kokne
 * @since 22-03-2018
 * @version 1.0
 *
 */

package com.bridgeit.objectoriented;

import java.util.ArrayList;
import com.bridgeit.utility.Utility;

public class DeckOfCards {

	/**
	 *the main function forms a deck of cards and distribute the 9 cards to 4 players 
	 *and prints the cards in 2 dimensional form.
	 */
	public static void main(String[] args) {
		String[] suit = {"Clubs","Diamonds", "Hearts", "Spades"};
		String[] rank = {"Ace","2", "3", "4", "5", "6", "7", "8", "9", "10","Jack","Queen", "King"};
		
		//creating a deck
		ArrayList<String> deck = new ArrayList<String>();
		
		//adding cards to deck
		Utility.formingDeck(suit, rank,deck);
		
		//printing the deck
		Utility.printDeck(deck);
		
		//shuffling the deck
		Utility.shuffleDeck(deck);
		
		System.out.println("\nafter shuffling\n");
		
		//printing the deck
		Utility.printDeck(deck);
		
		//distributing cards to players and printing the cards
		Utility.distributeAndDisplayCards(deck);
		

	}

}
