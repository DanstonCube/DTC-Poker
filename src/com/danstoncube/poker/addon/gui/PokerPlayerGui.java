package com.danstoncube.poker.addon.gui;

import org.spoutcraft.spoutcraftapi.Spoutcraft;
import org.spoutcraft.spoutcraftapi.gui.Container;
import org.spoutcraft.spoutcraftapi.gui.ContainerType;
import org.spoutcraft.spoutcraftapi.gui.GenericContainer;
import org.spoutcraft.spoutcraftapi.gui.GenericTexture;
import org.spoutcraft.spoutcraftapi.gui.WidgetAnchor;

import com.danstoncube.poker.enums.CardEnum;
import com.danstoncube.poker.addon.Poker;
import com.danstoncube.poker.addon.gui.widgets.CardWidget;
import com.danstoncube.poker.addon.gui.widgets.testLabel;


public class PokerPlayerGui
{
	public PokerPlayerGui() 
	{
		
		CardWidget flopCard1 = new CardWidget(CardEnum.AS_SPADES);
		CardWidget flopCard2 = new CardWidget(CardEnum.KING_HEARTS);
		CardWidget flopCard3 = new CardWidget(CardEnum.FIVE_CLUBS);
		
		Container testContainer = new GenericContainer();
		
		Spoutcraft.getLogger().info("container: " + testContainer);
		
		testContainer.setAnchor(WidgetAnchor.TOP_LEFT);
		testContainer.setLayout(ContainerType.HORIZONTAL);
		

		/* add a test label */
		
		testLabel label = new testLabel("TEST !");	
		
		/* add a test texture */
		
		GenericTexture testTexture = new GenericTexture(CardWidget.textureUrl);
		
		testTexture.setWidth(20).setHeight(20).setX(20).setY(20);
		
		
		//add children
		testContainer.addChildren(label,testTexture, flopCard1,flopCard2,flopCard3);

	 	
		Spoutcraft.getActivePlayer().getMainScreen().attachWidget(Poker.getAddon(), testContainer);
	
		//Label ok, but unable to see anything about generictextures, and so my cardwidgets wich extends it... :(
	}

	
}

