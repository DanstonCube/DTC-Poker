package com.danstoncube.poker.addon.packets;

import org.spoutcraft.spoutcraftapi.Spoutcraft;
import org.spoutcraft.spoutcraftapi.io.AddonPacket;
import org.spoutcraft.spoutcraftapi.io.SpoutInputStream;
import org.spoutcraft.spoutcraftapi.io.SpoutOutputStream;

import com.danstoncube.poker.enums.PlayerActionEnum;

public class PlayerActionPacket extends AddonPacket
{

	private String playerName = null;
	private PlayerActionEnum action = null;
	private Double bet = 0.0;
	private String gameId;
	
	
	public PlayerActionPacket(String gameId, String player, PlayerActionEnum action, Double chipsAmount)
	{
		this.setPlayerName(player).setAction(action).setBet(chipsAmount).setGameId(gameId);
	}


	private PlayerActionPacket setGameId(String id)
	{
		this.gameId = id;
		return this;
	}


	private PlayerActionPacket setPlayerName(String player)
	{
		this.playerName = player;
		return this;
	}
	
	public PlayerActionPacket setAction(PlayerActionEnum action)
	{
		this.action = action;
		return this;
	}
	
	public PlayerActionPacket setBet(Double bet)
	{
		this.bet = bet;
		return this;
	}

	
	private String getGameId()
	{
		return this.gameId;
	}

	public String getPlayerName()
	{
		return playerName;
	}

	public PlayerActionEnum getAction()
	{
		return action;
	}

	public Double getBet()
	{
		return bet;
	}


	


	@Override
	public void read(SpoutInputStream input)
	{
		setGameId(input.readString(""));
		setPlayerName(input.readString(""));
		setAction(PlayerActionEnum.valueOf(input.readString("")));
		setBet(input.readDouble());
		
		
		
		System.out.println("Someone played, game = " + this.getGameId() + " player = " + this.getPlayerName() + " action = " + this.getAction() + " betSize = " + this.getBet() );
		
		//TODO: beeep
		//TODO: show action buttons
	}


	


	@Override
	public void run()
	{
	}


	@Override
	public void write(SpoutOutputStream output)
	{		
		output.writeString(gameId);
		output.writeString(Spoutcraft.getActivePlayer().getName());
		output.writeString(action.toString());
		output.writeDouble(bet);
	}
	
	
	
	
	
}
