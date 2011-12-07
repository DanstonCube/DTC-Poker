package com.danstoncube.poker.plugin;

import com.danstoncube.poker.enums.PlayerActionEnum;
import com.danstoncube.poker.game.PokerGameListener;
import com.danstoncube.poker.game.PokerHand;
import com.danstoncube.poker.game.PokerPlayer;

public class GameListener  implements PokerGameListener
{
	
	private GameOperator gameop = null;

			
	public GameListener(GameOperator gameOperator)
	{
		this.setGameop(gameOperator);
	}
			
	
	@Override
	public void onNextStep()
	{
		//this.gameop.nextStep();
	}

	@Override
	public void onPlayerAction(PokerPlayer pokerPlayer, PlayerActionEnum action)
	{
		//Send packet to clients to let them know player played
		
		
	}

	@Override
	public void onNextHand(PokerHand newhand)
	{
		//Send packet to clients to let them know hand changed
		
		 
		
	}

	@Override
	public void onGameCreated()
	{
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void onGameStarted()
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onGameFinished()
	{
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onPlayerChanged()
	{
		// TODO Auto-generated method stub
		
	}

	public GameOperator getGameop()
	{
		return gameop;
	}


	public void setGameop(GameOperator gameop)
	{
		this.gameop = gameop;
	}


	

}
