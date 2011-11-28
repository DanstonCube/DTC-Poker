package com.danstoncube.Poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck
{

	public List<Card> cards = new ArrayList<Card>();
	
	CardDeck()
	{
		cards.add(Card.AS_SPADES);
		cards.add(Card.TWO_SPADES);
		cards.add(Card.THREE_SPADES);
		cards.add(Card.FOUR_SPADES);
		cards.add(Card.FIVE_SPADES);
		cards.add(Card.SIX_SPADES);
		cards.add(Card.SEVEN_SPADES);
		cards.add(Card.EIGHT_SPADES);
		cards.add(Card.NINE_SPADES);
		cards.add(Card.TEN_SPADES);
		cards.add(Card.JACK_SPADES);
		cards.add(Card.QUEEN_SPADES);
		cards.add(Card.KING_SPADES);
		
		cards.add(Card.AS_HEARTS);
		cards.add(Card.TWO_HEARTS);
		cards.add(Card.THREE_HEARTS);
		cards.add(Card.FOUR_HEARTS);
		cards.add(Card.FIVE_HEARTS);
		cards.add(Card.SIX_HEARTS);
		cards.add(Card.SEVEN_HEARTS);
		cards.add(Card.EIGHT_HEARTS);
		cards.add(Card.NINE_HEARTS);
		cards.add(Card.TEN_HEARTS);
		cards.add(Card.JACK_HEARTS);
		cards.add(Card.QUEEN_HEARTS);
		cards.add(Card.KING_HEARTS);
		
		cards.add(Card.AS_DIAMONDS);
		cards.add(Card.TWO_DIAMONDS);
		cards.add(Card.THREE_DIAMONDS);
		cards.add(Card.FOUR_DIAMONDS);
		cards.add(Card.FIVE_DIAMONDS);
		cards.add(Card.SIX_DIAMONDS);
		cards.add(Card.SEVEN_DIAMONDS);
		cards.add(Card.EIGHT_DIAMONDS);
		cards.add(Card.NINE_DIAMONDS);
		cards.add(Card.TEN_DIAMONDS);
		cards.add(Card.JACK_DIAMONDS);
		cards.add(Card.QUEEN_DIAMONDS);
		cards.add(Card.KING_DIAMONDS);
		
		cards.add(Card.AS_SPADES);
		cards.add(Card.TWO_SPADES);
		cards.add(Card.THREE_SPADES);
		cards.add(Card.FOUR_SPADES);
		cards.add(Card.FIVE_SPADES);
		cards.add(Card.SIX_SPADES);
		cards.add(Card.SEVEN_SPADES);
		cards.add(Card.EIGHT_SPADES);
		cards.add(Card.NINE_SPADES);
		cards.add(Card.TEN_SPADES);
		cards.add(Card.JACK_SPADES);
		cards.add(Card.QUEEN_SPADES);
		cards.add(Card.KING_SPADES);
		
		this.shuffle();
	}
	
	
	public void shuffle()
	{		
		
		Collections.shuffle(this.cards);
		//^ this is quite easier
		
		
		/*		
		-- DocteurZoidberg's way :
		 
		List<Card> tas1 = cards;		
		List<Card> tas2 = new ArrayList<Card>();

		while(tas1.size()>0)
		{
			Random rnd = new Random();
			
			//Nombre au pif entre 0 et la taille de cards
			int rndIndex = rnd.nextInt(cards.size());
			
			Card tmpCard = tas1.get(rndIndex);
			
			tas1.remove(rndIndex);
			tas2.add(tmpCard);
		}
		
		this.cards = tas2;
		*/
	}
	
	
	
	
	
}
