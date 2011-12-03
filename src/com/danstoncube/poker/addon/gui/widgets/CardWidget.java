package com.danstoncube.poker.addon.gui.widgets;


import org.spoutcraft.spoutcraftapi.gui.GenericTexture;
import com.danstoncube.poker.enums.CardEnum;



public class CardWidget extends GenericTexture
{
	//Whole cards texture
	public static final String textureUrl = "http://dl.dropbox.com/u/15091039/cards.png";
	
	public CardWidget(CardEnum cardEnum)
	{
		super(textureUrl);
		this.setWidth(10);
		this.setHeight(10);
	}
	
}
