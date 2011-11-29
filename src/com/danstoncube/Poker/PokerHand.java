package com.danstoncube.Poker;

import com.danstoncube.Poker.enums.CardEnum;



public class PokerHand
{
	public String id = "";
	
	public PokerPlayer winner = null;
	public PokerPlayer dealer = null;
	
	public boolean finished = false;
	
	public double smallBlind = 0.0;
	public double bigBlind = 0.0;
	
	public CardEnum[] flop = new CardEnum[5];
	
	
	
	
	PokerHand()
	{
		this.id = "A RANDOM ID"; //TODO
		
		
		
		
	}
}
