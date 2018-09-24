package com.info.gameMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.info.enumClasses.Player;
import com.info.enumClasses.Rank;
import com.info.enumClasses.Suit;
import com.info.exception.InvalidDistribution;


public class Deck {
	static Scanner input = new Scanner(System.in);
	public static List<Card> deck() {
		 List<Card> cards = new ArrayList<Card>();
		for(Suit suit: Suit.values()) {
			for(Rank rank : Rank.values()) {
				cards.add(new Card(rank,suit));
			}
		}
		return cards;
	}
	public static  int validCardsperHead = 0;
	   public int cardsPerHead () {
		   @SuppressWarnings("resource")
			 Scanner input = new Scanner( System.in);
			 int numberOfCards = input.nextInt();
	  	     
	    	 try{
	    		 
	    	    if(numberOfCards * Player.values().length > 52) {
	    	    	throw new InvalidDistribution("Please Enter the Valid Number to distribute");
	    	    }
	    	    else {
	    	    validCardsperHead = numberOfCards;
	    	    }
	    	 }catch(InvalidDistribution ex) {
	    		 System.out.println(ex);
	    		 cardsPerHead();
	    		 
	    	 }
	    return validCardsperHead;	 
	   }
	public  List<Card> deal(List<Card> cards, int cardsPerHead) {
		 int deckSize = cards.size();
         List<Card> handView = cards.subList(deckSize-cardsPerHead, deckSize);
         List<Card> hand = new ArrayList<Card>(handView);
         handView.clear();
         return hand;
	
	}

}