package com.danstoncube.poker.addon.gui;

import org.spoutcraft.spoutcraftapi.Spoutcraft;
import org.spoutcraft.spoutcraftapi.gui.Container;
import org.spoutcraft.spoutcraftapi.gui.ContainerType;
import org.spoutcraft.spoutcraftapi.gui.GenericContainer;
import org.spoutcraft.spoutcraftapi.gui.GenericLabel;
import org.spoutcraft.spoutcraftapi.gui.GenericPopup;
import org.spoutcraft.spoutcraftapi.gui.InGameHUD;
import org.spoutcraft.spoutcraftapi.gui.WidgetAnchor;

import com.danstoncube.poker.addon.Poker;
import com.danstoncube.poker.addon.gui.widgets.FlopWidget;
import com.danstoncube.poker.addon.gui.widgets.PlayerWidget;
import com.danstoncube.poker.game.PokerPlayer;


public class PokerPlayerGui extends GenericPopup
{
	public PokerPlayerGui() 
	{
		super();
		
		InGameHUD screen = Spoutcraft.getActivePlayer().getMainScreen();
			
		GenericLabel label = new GenericLabel("TEST !");
		
		//Flop widget contain 5 Cardwidget, horizontal layout
		FlopWidget flopWidget = new FlopWidget();
		
		
		/* Test players */
		PokerPlayer testPlayer1 = new PokerPlayer("TOTO");
		testPlayer1.setDealer(true);
		testPlayer1.setChips(1500.0);
		
		PokerPlayer testPlayer2 = new PokerPlayer("TITI");
		testPlayer2.setChips(1300.0);
		
		
		//Player widget contain avatar, player cards, chips, lastaction, conditionnal layout
		PlayerWidget playerWidget1 = new PlayerWidget(testPlayer1);
		PlayerWidget playerWidget2 = new PlayerWidget(testPlayer2);
		
		
		//Vertical container that contain a label, "flop" container, players widgets, vertical layout
		Container testVerticalContainer = new GenericContainer();
		
		testVerticalContainer.setWidth((int) flopWidget.getWidth());
		testVerticalContainer.setHeight((int) screen.getHeight());		
		testVerticalContainer.setX(0);
		testVerticalContainer.setY(0);	
		testVerticalContainer.setAnchor(WidgetAnchor.TOP_LEFT);
		testVerticalContainer.setLayout(ContainerType.VERTICAL);

		testVerticalContainer.addChildren(label, flopWidget,playerWidget1,playerWidget2);

		this.setTransparent(false);
		
		//Method1: attach container to screen : work fines ! 
		screen.attachWidget(Poker.getInstance(), testVerticalContainer);
		
		//Method2: attach container to genericpopup and genericpopup to screen : not working, containers broken
		//this.attachWidget(Poker.getInstance(), testVerticalContainer);
		//screen.attachPopupScreen(this);
	}
}

