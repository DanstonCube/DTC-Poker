package com.danstoncube.poker.game;

import com.danstoncube.poker.enums.HandStepEnum;

public class PokerStep
{
	//TODO: creer classe HandStep(type,curpot,raisemin)
	
	//Etape de la main, type (bet, flop, turn etc...)
	public HandStepEnum type = HandStepEnum.BET;
	
	//Mise en cours (mise max, celle a caller pour l'etape)
	public double pot = 0.0;
	
	//Montant minimum pour une relance pour l'etape en cours
	public double raisemin = 0.0;
	
		
	PokerStep(HandStepEnum steptype, double steppot, double stepraisemin)
	{
		type = steptype;
		pot = steppot;
		raisemin = stepraisemin;
	}
	
	
	public PokerStep(HandStepEnum steptype)
	{
		type = steptype;
	}


	public HandStepEnum getType()
	{
		return type;
	}
	
	public double setPot(double chipsamount)
	{
		this.pot = chipsamount;
		return this.pot;
	}

	public double addPot(double chipsamount)
	{
		this.pot += chipsamount;
		return this.pot;
	}
	
	public double removePot(double chipsamount)
	{
		this.pot -= chipsamount;
		return this.pot;
	}


	public Double getPot()
	{
		// TODO Auto-generated method stub
		return this.pot;
	}
	
	
}
