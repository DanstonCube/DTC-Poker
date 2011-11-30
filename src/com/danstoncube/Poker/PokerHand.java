package com.danstoncube.Poker;

import com.danstoncube.Poker.enums.CardEnum;
import com.danstoncube.Poker.enums.HandStepEnum;



public class PokerHand
{
	public String id = "";
	
	public PokerPlayer winner = null;
	public PokerPlayer dealer = null;
	
	public boolean finished = false;
	
	public double smallBlind = 0.0;
	public double bigBlind = 0.0;
	private double pot = 0.0;
	
	
	//Etape de la main en cours (bet, flop, turn, etc)
	public PokerStep step = new PokerStep(HandStepEnum.BET,0.0,0.0);
	
	
	
	public CardEnum[] flop = new CardEnum[5];

	
	PokerHand()
	{
		this.id = "A RANDOM ID"; //TODO: id unique (un tour est unique)
	}



	public void addPot(Double chips)
	{
		this.pot += pot;
	}
	
	public void setPot(Double pot)
	{
		this.pot  = pot;
		
	}




	public double getPot()
	{
		return pot;
	}




	public void setPot(double pot)
	{
		this.pot = pot;
	}



	public PokerStep getStep()
	{	
		return step;
	}



	public void setStep(PokerStep pokerStep)
	{
		step = pokerStep;
		
	}
}
