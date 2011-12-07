package com.danstoncube.poker.addon.packets;

import org.spoutcraft.spoutcraftapi.io.AddonPacket;
import org.spoutcraft.spoutcraftapi.io.SpoutInputStream;
import org.spoutcraft.spoutcraftapi.io.SpoutOutputStream;

import com.danstoncube.poker.enums.PlayerActionEnum;
import com.danstoncube.poker.game.PokerPlayer;

public class PlayerActionPacket extends AddonPacket
{
	
	private PokerPlayer _pokerPlayer = null;
	private PlayerActionEnum _action = null;
	private Double _bet = 0.0;
	
	
	public PlayerActionPacket(PokerPlayer player, PlayerActionEnum action, Double bet)
	{
		this.setPokerPlayer(player).setAction(action).setBet(bet);
	}


	public PokerPlayer getPokerPlayer()
	{
		return _pokerPlayer;
	}


	public PlayerActionPacket setPokerPlayer(PokerPlayer  pokerPlayer)
	{
		this._pokerPlayer = pokerPlayer;
		return this;
	}


	public PlayerActionEnum getAction()
	{
		return _action;
	}


	public PlayerActionPacket setAction(PlayerActionEnum action)
	{
		this._action = action;
		return this;
	}


	public Double getBet()
	{
		return _bet;
	}


	public PlayerActionPacket setBet(Double bet)
	{
		this._bet = bet;
		return this;
	}


	@Override
	public void read(SpoutInputStream input)
	{
		String playerName = input.readString("");
		PlayerActionEnum action = PlayerActionEnum.valueOf(input.readString(""));
		double betSize = input.readDouble();
		
		//Game.getGame().
		
		System.out.println("Someone played, player = " + playerName + " action = " + action + " betSize = " + betSize );
		
		//TODO: beeep
		//TODO: show action buttons
	}


	@Override
	public void run()
	{
		// TODO Auto-generated method stub
	}


	@Override
	public void write(SpoutOutputStream output)
	{		
		output.writeString(_pokerPlayer.getPlayerName());
		output.writeString(_action.toString());
		output.writeDouble(_bet);		
	}
	
	
	
	
	
}
