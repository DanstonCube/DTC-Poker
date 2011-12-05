package com.danstoncube.poker.addon.gui.widgets;

import org.spoutcraft.spoutcraftapi.gui.GenericWidget;
import org.spoutcraft.spoutcraftapi.gui.WidgetType;

import com.danstoncube.poker.game.PokerPlayer;


public class PlayerWidget extends GenericWidget
{
	private PokerPlayer player = null;
		
	PlayerWidget(PokerPlayer spoutPlayer)
	{
		this.player = spoutPlayer;
	}
	
	public PokerPlayer getPlayer()
	{
		return this.player;
	}
	
	public void setPlayer(PokerPlayer spoutPlayer)
	{
		this.player = spoutPlayer;		
	}

	@Override
	public WidgetType getType()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void render()
	{
		// TODO Auto-generated method stub
		
	}
	
	

}
