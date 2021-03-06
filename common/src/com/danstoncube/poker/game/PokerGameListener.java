	package com.danstoncube.poker.game;

import com.danstoncube.poker.enums.PlayerActionEnum;

public interface PokerGameListener
{
	public void onGameCreated();
	public void onGameStarted();
	public void onGameFinished();
	
	
	public void onNextHand(PokerHand newhand);		
	public void onNextStep(PokerStep newStep);		
	public void onPlayerAction(PokerPlayer pokerPlayer, PlayerActionEnum action, double chipsamount);
	public void onPlayerChanged(PokerPlayer pokerPlayer);


	
	
}
