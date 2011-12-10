package com.danstoncube.poker.addon.gui.widgets;

import org.spoutcraft.spoutcraftapi.gui.ContainerType;
import org.spoutcraft.spoutcraftapi.gui.GenericContainer;
import org.spoutcraft.spoutcraftapi.gui.WidgetAnchor;


import com.danstoncube.poker.enums.CardEnum;

//5 cards container
public class FlopWidget extends GenericContainer
{
	public FlopWidget()
	{
		CardWidget flopCard1 = new CardWidget(CardEnum.AS_SPADES);
		CardWidget flopCard2 = new CardWidget(CardEnum.KING_HEARTS);
		CardWidget flopCard3 = new CardWidget(CardEnum.FIVE_CLUBS);
		CardWidget flopCard4 = new CardWidget(CardEnum.FIVE_CLUBS);
		CardWidget flopCard5 = new CardWidget(CardEnum.FIVE_CLUBS);
				
		this.setX(0);
		this.setY(0);
		this.setWidth(CardWidget.cardWidth*5);
		this.setHeight(CardWidget.cardHeight);
		
		this.setAnchor(WidgetAnchor.TOP_LEFT);
		this.setLayout(ContainerType.HORIZONTAL);
		
		this.addChildren(flopCard1,flopCard2,flopCard3,flopCard4,flopCard5);
	}

	
}
