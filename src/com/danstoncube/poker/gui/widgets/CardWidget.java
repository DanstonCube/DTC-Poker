package com.danstoncube.poker.gui.widgets;

import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.gui.GenericTexture;
import org.getspout.spoutapi.gui.GenericWidget;
import org.getspout.spoutapi.gui.Texture;
import org.getspout.spoutapi.gui.WidgetType;

import com.danstoncube.poker.Poker;
import com.danstoncube.poker.enums.CardEnum;



public class CardWidget extends GenericWidget
{
	private static String textureUrl = "http://dl.dropbox.com/u/15091039/cards.png";
	private static Texture texture = null;
	
	private CardEnum card = null;
	
	public static void precacheTexture()
	{
		SpoutManager.getFileManager().addToPreLoginCache(Poker.getInstance(), textureUrl);		
	}
	
	public static void loadTexture()
	{		
		texture = new GenericTexture(textureUrl);					
	}
	
	public CardWidget()
	{
		
	}
	
	public CardWidget(CardEnum card)
	{
		setCard(this.card);
	}
	
	public CardEnum getCard()
	{
		return this.card;
	}
	
	public void setCard(CardEnum card)
	{
		this.card = card;
	}
	
	//Renvoi la texture de la partie correspondant à la carte
	public Texture getTexture()
	{
		int textureindex = 0;

		return texture;
		//SubTexture subTex = texture.getSubTexture(textureindex);
		//return subTex;
	}

	@Override
	public WidgetType getType()
	{
		return WidgetType.Texture;
	}
	
	
	
	
}
