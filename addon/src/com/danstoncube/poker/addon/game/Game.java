package com.danstoncube.poker.addon.game;

import java.util.ArrayList;
import java.util.List;

import com.danstoncube.poker.enums.PlayerActionEnum;
import com.danstoncube.poker.game.PokerGameListener;
import com.danstoncube.poker.game.PokerHand;
import com.danstoncube.poker.game.PokerPlayer;
import com.danstoncube.poker.game.PokerStep;



public class Game implements PokerGameListener
{
	
	
	
	public static Game _instance = null;
	
	



	public static Game getInstance()
	{
		if(_instance == null)
			_instance = new Game();
		
		return _instance;
	}
	
	
	
	private String id = "";
	private List<PokerPlayer> players = new ArrayList<PokerPlayer>();
	
	
	//private PokerPlayer player = "";

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}
	
	public List<PokerPlayer> getPlayers()
	{
		return players;
	}

	public void setPlayers(List<PokerPlayer> players)
	{
		this.players = players;
	}
	
	
	@Override
	public void onGameCreated()
	{
	}

	@Override
	public void onGameStarted()
	{
	}

	@Override
	public void onGameFinished()
	{
	}

	@Override
	public void onNextHand(PokerHand newhand)
	{
	}

	@Override
	public void onNextStep(PokerStep newStep)
	{
	}

	@Override
	public void onPlayerAction(PokerPlayer pokerPlayer,
			PlayerActionEnum action, double chipsamount)
	{
		//TODO: gui render ? 
	}

	@Override
	public void onPlayerChanged(PokerPlayer pokerPlayer)
	{
	}
	

	public PokerPlayer getPlayer(String playerName)
	{
		//A faire mieux avec autre chose qu'un arraylist...
		for(PokerPlayer player : players)
		{
			if(player.getPlayerName().compareToIgnoreCase(playerName)==0)
				return player;
		}
		return null;
	}

	
	
	
	
	
}
