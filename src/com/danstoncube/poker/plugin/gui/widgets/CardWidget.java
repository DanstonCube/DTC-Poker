package com.danstoncube.poker.plugin.gui.widgets;

import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.WidgetAnchor;
import com.danstoncube.poker.enums.CardEnum;



public class CardWidget extends GenericTexture
{
	//Whole cards texture
	private static String textureUrl = "http://dl.dropbox.com/u/15091039/cards.png";
	
	private CardEnum card = null;

	//Display card or card back ?
	private boolean show = true;
	
	public CardWidget(CardEnum cardEnum)
	{
		super(textureUrl);
		
		//Card width
		int cardWidth = 79;
		
		//Card height
		int cardHeight = 123;

		//Screenshots provided are with and without this setAnchor !
		this.setAnchor(WidgetAnchor.TOP_LEFT);
				
		this.setWidth(cardWidth);
		this.setHeight(cardHeight);
		this.setLeft(0);
		this.setTop(0);		
		
		//Should display first card of the cards texture !
	}
	
	
	public CardEnum getCard()
	{
		return this.card;
	}
	
	public boolean getShow()
	{
		return this.show;
	}

	public void setShow(boolean show)
	{
		this.show = show;
	}
	
}
