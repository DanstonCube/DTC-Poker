package com.danstoncube.poker.gui;

import java.util.UUID;


import org.bukkit.plugin.Plugin;
import org.getspout.spoutapi.gui.Button;
import org.getspout.spoutapi.gui.Color;
import org.getspout.spoutapi.gui.Container;
import org.getspout.spoutapi.gui.ContainerType;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericContainer;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.WidgetAnchor;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.danstoncube.poker.enums.CardEnum;
import com.danstoncube.poker.gui.widgets.CardWidget;
import com.danstoncube.poker.plugin.Poker;

@SuppressWarnings("unused")
public class PokerPlayerGui extends GenericPopup
{
	
	final Plugin poker = Poker.getInstance();
	
	SpoutPlayer player = null;
	

	public PokerPlayerGui(SpoutPlayer sPlayer) 
	{
		player = sPlayer;
		
		Container box = new GenericContainer();

		int widthScale = sPlayer.getMainScreen().getWidth() / 100;
		int heightScale = sPlayer.getMainScreen().getHeight() / 100;

		
		box.setLayout(ContainerType.HORIZONTAL);
		box.setAnchor(WidgetAnchor.TOP_LEFT);
		
		//Fullscreen
		box.setWidth(widthScale * 100).setHeight(heightScale * 100);


		
		//Add 3 sample card widget
		
		CardWidget flopCard1 = new CardWidget(CardEnum.AS_SPADES);
		CardWidget flopCard2 = new CardWidget(CardEnum.KING_HEARTS);
		CardWidget flopCard3 = new CardWidget(CardEnum.FIVE_CLUBS);
		

		box.addChildren(flopCard1,flopCard2,flopCard3);
		
		
		this.attachWidget(poker, box);
		
		player.getMainScreen().attachPopupScreen(this);
	}


	
	
	
}

