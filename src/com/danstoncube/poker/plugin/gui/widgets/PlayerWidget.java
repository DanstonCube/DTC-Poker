package com.danstoncube.poker.plugin.gui.widgets;

import org.getspout.spoutapi.gui.GenericWidget;
import org.getspout.spoutapi.gui.WidgetType;
import org.getspout.spoutapi.player.SpoutPlayer;

public class PlayerWidget extends GenericWidget
{
	private SpoutPlayer player = null;
		
	PlayerWidget(SpoutPlayer spoutPlayer)
	{
		this.player = spoutPlayer;
	}
	
	public SpoutPlayer getPlayer()
	{
		return this.player;
	}
	
	public void setPlayer(SpoutPlayer spoutPlayer)
	{
		this.player = spoutPlayer;		
	}
	
	@Override
	public WidgetType getType()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
