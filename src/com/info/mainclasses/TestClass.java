package com.info.mainclasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

import com.info.enumClasses.Player;
import com.info.gameMethods.Card;
import com.info.gameMethods.Deck;
;


public class TestClass {
	Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		Map<Player,List<Card>> cardsOnHands = new HashMap<Player, List<Card>>();
		Map<Integer, List<Player>> playerWithRank = new TreeMap<Integer,List< Player>>();
		List<Card> cards = Deck.deck();
		Deck deck = new Deck();
		Collections.shuffle(cards);
		System.out.println("Enter Cards per head");
		int cardsPerHead = deck.cardsPerHead();
		for(Player p : Player.values()) {
			cardsOnHands.put(p, deck.deal(cards, cardsPerHead));
		}
		
	for (Entry<Player, List<Card>> entry :cardsOnHands.entrySet()) {
		     System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		}
	for (Entry<Player, List<Card>> entry :cardsOnHands.entrySet()) {
		int sumOfRanks = 0 ;
	   for(Card c : entry.getValue()) {
		sumOfRanks  +=   c.getRank().getValue();
	   		}
	   objects( playerWithRank,sumOfRanks,entry.getKey());
	   
		}
		System.out.println(playerWithRank);
		Entry<Integer,List<Player>> entry = ((TreeMap<Integer, List<Player>>) playerWithRank).lastEntry();
		if(entry.getValue().size()==1) {
			System.out.println("Winner is  :" +entry.getValue());
		}
		else
			System.out.println("Game is Tie between:" + entry.getValue());
		
		
	}
	private static void objects (Map<Integer,List<Player>> playerWithRank, int rank , Player player) {
		List<Player> playerConstant = playerWithRank.get(rank);
		if(playerConstant == null) {
			playerConstant = new ArrayList<Player>();
			playerWithRank.put(rank, playerConstant);
			}
		playerConstant.add(player);
	}

}
