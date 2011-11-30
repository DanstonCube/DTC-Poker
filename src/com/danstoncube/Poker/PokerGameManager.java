package com.danstoncube.Poker;

import java.util.HashMap;



public class PokerGameManager
{
	private HashMap<String,PokerGame> _games = new HashMap<String,PokerGame>();
	
	
	public HashMap<String,PokerGame> getGames()
	{
		return _games;
	}
	
	
	public PokerGame getGame(String GameID)
	{
		if(_games.containsKey(GameID))
			return _games.get(GameID);		
		
		return null;
	}
	
	
	
	/// Démarre une nouvelle partie ( = table ? )
	public PokerGame startNewGame(int minPlayers, int maxPlayers)
	{	
		//TODO: lire min et max players depuis la conf ou gui ?
		PokerGame newGame = new PokerGame(minPlayers,maxPlayers);
		
		_games.put(newGame.getId(), newGame);
		
		return newGame;
		
	}
	
	
	
	
}
