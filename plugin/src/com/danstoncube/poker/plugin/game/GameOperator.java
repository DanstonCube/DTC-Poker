package com.danstoncube.poker.plugin.game;

import org.getspout.spoutapi.player.SpoutPlayer;

import com.danstoncube.poker.game.PokerGame;

public class GameOperator
{
	
	private PokerGame _game = null;
	
	public GameOperator(PokerGame game)
	{
		setGame(game);
	}
	
	//If server is creator, creator should be null
	private SpoutPlayer _creator = null;
	

	/* Creator is server-side only */
	
	public SpoutPlayer getCreatorPlayer()
	{
		return _creator;
	}
	
	public void setCreatorPlayer(SpoutPlayer player)
	{
		_creator = player;
	}


	public PokerGame getGame()
	{
		return _game;
	}

	public void setGame(PokerGame _game)
	{
		this._game = _game;
	}

	
}
