package com.danstoncube.Poker;

import java.util.ArrayList;
import java.util.List;

public class CardDeck
{

	public List<Card> cards = new ArrayList<Card>();
	
	CardDeck()
	{
		cards.add(Card.AS_SPADES);
		
		//TODO: add all cards in Card.java
		
		this.shuffle();
		
	}
	
	
	public void shuffle()
	{
		//TODO: randomize cards order
	}
	
	
	
	
	
}
