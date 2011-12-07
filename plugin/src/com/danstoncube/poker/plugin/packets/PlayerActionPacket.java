package com.danstoncube.poker.plugin.packets;

import org.getspout.spoutapi.io.AddonPacket;
import org.getspout.spoutapi.io.SpoutInputStream;
import org.getspout.spoutapi.io.SpoutOutputStream;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.danstoncube.poker.enums.PlayerActionEnum;
import com.danstoncube.poker.game.PokerGame;
import com.danstoncube.poker.game.PokerPlayer;
import com.danstoncube.poker.plugin.Poker;

public class PlayerActionPacket extends AddonPacket
{

	private String gameId = "";
	private String playerName = "";
	private PlayerActionEnum playerAction;
	private double chips;
	
	@Override
	public void read(SpoutInputStream arg0)
	{
		gameId = arg0.readString("");		
		playerName = arg0.readString("");
		playerAction = PlayerActionEnum.valueOf(arg0.readString(""));
		chips = arg0.readDouble();
		
		PokerGame game = Poker.getGameManager().getGame(gameId).getGame();
		PokerPlayer player = game.getPlayer(playerName);
		
		
		//TODO: verif que c'est bien au joueur de jouer ?
		
		
		game.playerPlay(player, playerAction, chips);
		
		
		
	}

	@Override
	public void run(SpoutPlayer arg0)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void write(SpoutOutputStream arg0)
	{
		arg0.writeString(gameId);		
		arg0.writeString(playerName);
		arg0.writeString(playerAction.toString());
		arg0.writeDouble(chips);		
	}

	
	public PlayerActionPacket setGameId(String gameId)
	{
		this.gameId = gameId;
		return this;
	}
	
	public PlayerActionPacket setPlayer(PokerPlayer player)
	{
		this.playerName = player.getPlayerName();
		return this;
	}
	
	public PlayerActionPacket setPlayerName(String playerName)
	{
		this.playerName = playerName;
		return this;
	}
	
	public PlayerActionPacket setGame(PokerGame game)
	{
		this.gameId = game.getId();
		return this;
	}
		
	public PlayerActionPacket setPlayerAction(PlayerActionEnum action)
	{
		this.playerAction = action;
		return this;
	}

	public PlayerActionPacket setChipsAmount(double chipsAmount)
	{
		this.chips = chipsAmount;
		return this;
	}
	
	
	
}
