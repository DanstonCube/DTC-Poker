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


public class PokerPlayerGui extends GenericPopup
{
	public PokerPlayerGui() 
	{
		InGameHUD screen = Spoutcraft.getActivePlayer().getMainScreen();
			
		GenericLabel label = new GenericLabel("TEST !");
		FlopWidget flopWidget = new FlopWidget();
		
		
		//Vertical container that contain "flop" container and a label 
		Container testVerticalContainer = new GenericContainer();
		
		testVerticalContainer.setWidth((int) flopWidget.getWidth());
		testVerticalContainer.setHeight((int) screen.getHeight());		
		testVerticalContainer.setX(0);
		testVerticalContainer.setY(0);	
		testVerticalContainer.setAnchor(WidgetAnchor.TOP_LEFT);
		testVerticalContainer.setLayout(ContainerType.VERTICAL);

		testVerticalContainer.addChildren(label, flopWidget);

		this.setTransparent(false);
		
		//Method1: attach container to screen : work fines ! 
		screen.attachWidget(Poker.getInstance(), testVerticalContainer);
		
		//Method2: attach container to genericpopup and genericpopup to screen : not working, containers broken
		//this.attachWidget(Poker.getInstance(), testVerticalContainer);
		//screen.attachPopupScreen(this);
	}
}

