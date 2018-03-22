/**
 * Purpose :The program forming a deck of cards and distributing 9 cards to 
 * 			4 players.then it sorting the cards of each player and storing 
 * 			them in an Queue and printing the sorted cards of each player 
 * 			from queue.
 * 
 * @author Pranit_kokne
 * @since 22-03-2018
 * @version 1.0
 *
 */

package com.bridgeit.objectoriented;

import java.util.Random;
import com.bridgeit.datastructure.MyLinkedList;
import com.bridgeit.datastructure.MyQueue;

public class DeckOfCardsUsingQueue {
	
	public static void formingDeck(String[] suit,String[] rank,MyLinkedList<String> deck) 
	{
		
		
		for(int i=0;i<suit.length;i++) 
		{
			for(int j=0;j<rank.length;j++) 
			{
				deck.add(suit[i]+" of "+rank[j]);
			}
		}
	}
	
	public static void printDeck(MyLinkedList<String> deck) 
	{
		int count = 0;
		
		for(int i=0;i<deck.size();i++)
			System.out.println(deck.get(i));
	}
	
	public static void shuffleDeck(MyLinkedList<String> deck) 
	{
		Random random = new Random();
		for(int i=0;i<52;i++) 
		{
			int no1 = random.nextInt(52);
			int no2 = random.nextInt(52);
			
			String first = deck.get(no1);
			String second = deck.get(no2);
			
			String temp = first;
			first = second;
			second = temp;
			deck.set(no1, first);
			deck.set(no2, second);
		}
	}
	
	public static String[] sortedCards(String[] player) 
	{
		String[] cards = player;
		
		String[] lastWords = new String[cards.length];
		
		for(int i=0;i<cards.length;i++) 
		{
			String[] words = cards[i].split(" ");
			lastWords[i] = words[2];
		}

		String[] numbers = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		
		Integer[] index = new Integer[lastWords.length];
		
		for(int i=0;i<lastWords.length;i++) 
		{
			for(int j=0;j<numbers.length;j++) 
			{
				if(lastWords[i].equals(numbers[j]))
				{
					index[i] = j;
				}
			}
		}
		//sorted array 
		String[] sort = new String[cards.length];
		int count = 0;
		for(int j=0;j<numbers.length;j++) 
		{
			for(int i=0;i<index.length;i++) 
			{
				if(index[i]==j) 
				{
					sort[count]=cards[i];
					count++;
				}
			}
		}
		
	return sort;	
	}
		
	
	public static void printFromQueue(String[] sortedCard,int playerCount) 
	{
		MyQueue<String> cards = new MyQueue<String>();
		
		cards.enQueue("Player "+(playerCount+1));
		for(int q=0;q<9;q++) 
		{
			cards.enQueue(sortedCard[q]);
		}
		
		for(int l=0;l<10;l++) 
		{
			System.out.print(cards.DeQueue()+" ");
		}
		System.out.println();
	
	}
	

	public static void main(String[] args) {
		String[] suit = {"Clubs","Diamonds", "Hearts", "Spades"};
		String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10","Jack","Queen","King","Ace"};
		
		//creating a deck 
		MyLinkedList<String> deck = new MyLinkedList<String>();
		//adding cards to deck
		formingDeck(suit,rank,deck);
		//printing the deck
		printDeck(deck);
		System.out.println();
		//shuffling the deck
		shuffleDeck(deck);
		//printing the deck
		printDeck(deck);
		System.out.println();
		//storing the 9 cards of each player in an array
		String[] player = new String[9];
		
		int count1 = 0;
		//sorting the cards and printing them from queue.
		for(int j=0;j<4;j++) 
		{
			for(int i=0;i<9;i++) 
			{
				player[i]=deck.get(count1);
				count1++;
			}
			String[] sortedCard = sortedCards(player);
			printFromQueue(sortedCard,j);
		}
	}

}
