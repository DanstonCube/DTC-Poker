package com.danstoncube.poker.addon.gui.widgets;


import org.spoutcraft.spoutcraftapi.gui.GenericTexture;
import org.spoutcraft.spoutcraftapi.gui.WidgetAnchor;

import com.danstoncube.poker.enums.CardEnum;



public class CardWidget extends GenericTexture
{
	//Whole cards texture
	public static final String textureUrl = "http://dl.dropbox.com/u/15091039/cards.png";
	public static final int cardWidth = 79;
	public static final int cardHeight = 123;
	
	public CardWidget(CardEnum cardEnum)
	{
		super(textureUrl);
		
		this.setUrl(textureUrl);		
		
		this.setX(0);
		this.setY(0);
		this.setWidth(cardWidth);
		this.setHeight(cardHeight);		
		this.setAnchor(WidgetAnchor.TOP_LEFT);
		this.setLeft(0);
		this.setTop(0);
	}
	
}
