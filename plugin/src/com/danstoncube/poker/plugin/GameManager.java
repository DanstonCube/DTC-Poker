package com.danstoncube.poker.plugin;

import java.util.HashMap;

import org.getspout.spoutapi.player.SpoutPlayer;

import com.danstoncube.poker.game.PokerGame;
import com.danstoncube.poker.plugin.packets.CreateGamePacket;



public class GameManager
{
	private HashMap<String,GameOperator> _games = new HashMap<String,GameOperator>();
	
	
	public HashMap<String,GameOperator> getGames()
	{
		return _games;
	}
	
	
	public GameOperator getGame(String GameID)
	{
		if(_games.containsKey(GameID))
			return _games.get(GameID);		
		
		return null;
	}
	
	
	
	/// Démarre une nouvelle partie ( = table ? )
	public GameOperator createNewGame(int minPlayers, int maxPlayers, SpoutPlayer creator)
	{	
		//TODO: lire min et max players depuis la conf ou gui ?
		GameOperator operator = new GameOperator(new PokerGame(minPlayers, maxPlayers));
		
		operator.setCreatorPlayer(creator);
		
		operator.getGame().addPokerGameListener(new GameListener(operator));
		
		_games.put(operator.getGame().getId(), operator);
		
		if(creator!=null)
		{	
		
			CreateGamePacket packet = new CreateGamePacket();
			packet.send(operator.getCreatorPlayer());
		}
		
		return operator;		
	}
	
	
	
	
}
