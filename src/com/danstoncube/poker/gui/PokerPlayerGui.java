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

import com.danstoncube.poker.Poker;
import com.danstoncube.poker.gui.widgets.CardWidget;

@SuppressWarnings("unused")
public class PokerPlayerGui extends GenericPopup
{
	/*
	private final UUID b1ID;
	private final UUID b2ID;
	private final UUID b3ID;
	private final UUID b4ID;
	*/
	
	final Plugin poker = Poker.getInstance();
	
	SpoutPlayer player = null;
	

	PokerPlayerGui(SpoutPlayer sPlayer) 
	{
		player = sPlayer;
		
		Container box = new GenericContainer();

		int widthScale = sPlayer.getMainScreen().getWidth() / 100;
		int heightScale = sPlayer.getMainScreen().getHeight() / 100;

		box.setLayout(ContainerType.VERTICAL);
		//box.setAnchor(WidgetAnchor.CENTER_CENTER);
		box.setWidth(widthScale * 50).setHeight(heightScale * 50);
		//box.shiftYPos(-(box.getHeight()/2));
		//box.shiftXPos(-(box.getWidth()/2));

		
		//TODO: calculer positions des cartes du flop
		
		CardWidget flopCard1 = new CardWidget();
		flopCard1.setX(0);
		flopCard1.setY(0);
		
		CardWidget flopCard2 = new CardWidget();
		flopCard2.setX(0);
		flopCard2.setY(0);
		
		CardWidget flopCard3 = new CardWidget();
		flopCard3.setX(0);
		flopCard3.setY(0);
		
		CardWidget flopCard4 = new CardWidget();
		flopCard4.setX(0);
		flopCard4.setY(0);
		
		CardWidget flopCard5 = new CardWidget();
		flopCard5.setX(0);
		flopCard5.setY(0);
		
		
		box.addChildren(flopCard1,flopCard2,flopCard3,flopCard4,flopCard5);
		
		this.setTransparent(true);
		
		this.attachWidget(poker, box);
		
		this.show();
	}

	/*
	public boolean isB1(Button button) {
		return button.getId().equals(b1ID);
	}

	public boolean isB2(Button button) {
		return button.getId().equals(b2ID);
	}
	
	public boolean isB3(Button button) {
		return button.getId().equals(b3ID);
	}

	public boolean isB4(Button button) {
		return button.getId().equals(b4ID);
	}
	*/
	
	
	public void show()
	{
		player.getMainScreen().attachPopupScreen(this);
	}
	
	public void hide()
	{
		this.setVisible(false);
	}
	
	
	
	
}

