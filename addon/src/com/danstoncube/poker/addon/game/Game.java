package com.danstoncube.poker.addon.game;

import com.danstoncube.poker.game.PokerGame;

public class Game extends PokerGame
{

	public static Game _instance = null;
	
	public static Game getGame()
	{
		if(_instance == null)
		{
			_instance = new Game(0,0);
			_instance.addPokerGameListener(new GameListener());
		}	
			
		return _instance;		
	}
	
	
	public Game(int minplayers, int maxplayers)
	{
		super(minplayers, maxplayers);
		// TODO Auto-generated constructor stub
	}

}
