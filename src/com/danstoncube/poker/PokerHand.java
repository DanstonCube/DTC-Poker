package com.danstoncube.poker;

import com.danstoncube.poker.enums.CardEnum;
import com.danstoncube.poker.enums.HandStepEnum;



public class PokerHand
{
	public String id = "";
	
	public PokerPlayer winner = null;
	public PokerPlayer dealer = null;
	public PokerPlayer bbplayer = null;
	public PokerPlayer sbplayer = null;
	public PokerPlayer splayer = null;
	
	
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

	public void setDealer(PokerPlayer playerAt)
	{
		playerAt.setDealer(true);
		this.dealer = playerAt;
	}

	public void setSmallBlindPlayer(PokerPlayer playerAt)
	{
		playerAt.setSmallBlind(true);
		this.sbplayer = playerAt;
	}

	public void setBigBlindPlayer(PokerPlayer playerAt)
	{
		playerAt.setBigBlind(true);
		this.bbplayer = playerAt;
	}

	public void setStartPlayer(PokerPlayer playerAt)
	{
		playerAt.setDealer(true);
		this.splayer = playerAt;
	}
}
