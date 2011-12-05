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
	
		int cardWidth = (int) (79);
		int cardHeight = (int) (123);
		
		this.setUrl(textureUrl);
		
		this.setWidth(cardWidth);
		this.setHeight(cardHeight);
		this.setLeft(0);
		this.setTop(0);

	}
	
}
