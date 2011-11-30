package com.danstoncube.Poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.danstoncube.Poker.enums.CardEnum;

public class CardDeck
{

	public List<CardEnum> cards = new ArrayList<CardEnum>();
	
	public CardDeck()
	{
		for(CardEnum aCard : CardEnum.values()){
			cards.add(aCard);
		}		
		this.shuffle();
	}
	
	
	//Donne une carte au pif du ceck a un joueur (et l'enleve du deck)
	public void giveCard(PokerPlayer player)
	{
		Random rnd = new Random();
		int rndIndex = rnd.nextInt(this.cards.size());
		
		player.giveCard(this.cards.get(rndIndex));
		
		this.cards.remove(rndIndex);
	}
	
	//La meme avec une quantité
	public void giveCard(PokerPlayer player, int count)
	{
		for(int i=0;i<=count;i++)
		{
			giveCard(player);
		}
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
