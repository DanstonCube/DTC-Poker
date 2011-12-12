package com.danstoncube.poker.addon.gui.widgets;

import org.spoutcraft.spoutcraftapi.gui.ContainerType;
import org.spoutcraft.spoutcraftapi.gui.GenericContainer;
import org.spoutcraft.spoutcraftapi.gui.GenericLabel;
import org.spoutcraft.spoutcraftapi.gui.GenericTexture;
import org.spoutcraft.spoutcraftapi.gui.RenderPriority;
import org.spoutcraft.spoutcraftapi.gui.WidgetAnchor;
import org.spoutcraft.spoutcraftapi.gui.WidgetType;

import com.danstoncube.poker.enums.CardEnum;
import com.danstoncube.poker.game.PokerPlayer;


public class PlayerWidget extends GenericContainer
{
	private PokerPlayer player = null;
	
	public static final String avatarTextureUrl = "http://dl.dropbox.com/u/15091039/avatar.png";
	
	
	CardEnum[] cards = new CardEnum[2];
	
	private Double chipsTotal = 0.0;
	private Double chipsStep = 0.0;
	private String lastActionString = "";
	
	private Boolean dealer = false;
	private Boolean play = false;



	private final  int coefWidth = 10;
	private final  int coefHeight = 10;
	
	
	
	public PlayerWidget(PokerPlayer pokerPlayer)
	{
		super();
		
		this.player = pokerPlayer;
		this.player.resetCards();
		
		this.setAnchor(WidgetAnchor.TOP_LEFT);
		this.setX(0);
		this.setY(0);
		this.setWidth(5 * coefWidth);
		this.setWidth(2 * coefHeight);
		
		this.setLayout(ContainerType.OVERLAY);
		
		
		//layer1 
		
		// - name 
		GenericLabel labelName = new GenericLabel(pokerPlayer.getPlayerName());		
		labelName.setX(0);
		labelName.setY(0);
		labelName.setWidth(3 * coefWidth);
		labelName.setHeight(1 * coefHeight);
		labelName.setAnchor(WidgetAnchor.TOP_LEFT);
		labelName.setPriority(RenderPriority.Lowest);
		
		// - chipstotal
		GenericLabel labelChipsTotal = new GenericLabel(String.valueOf(pokerPlayer.getChips()));
		labelChipsTotal.setAnchor(WidgetAnchor.TOP_LEFT);
		labelChipsTotal.setX(0);
		labelChipsTotal.setY(0);
		labelChipsTotal.setWidth(3 * coefWidth);
		labelChipsTotal.setHeight(1 * coefHeight);
		labelChipsTotal.setPriority(RenderPriority.Lowest);
		labelChipsTotal.shiftXPos(1 * coefHeight);
		
		
		// - avatar
		
		GenericTexture textureAvatar = new GenericTexture(avatarTextureUrl);		
		textureAvatar.setAnchor(WidgetAnchor.TOP_LEFT);
		textureAvatar.setX(0);
		textureAvatar.setY(0);
		textureAvatar.setWidth(2 * coefWidth);
		textureAvatar.setHeight(2 * coefHeight);		
		textureAvatar.setPriority(RenderPriority.Lowest);
		textureAvatar.shiftYPos(3 * coefWidth);
		//layer2
		
		//layer3
		
		this.addChildren(labelName,labelChipsTotal,textureAvatar);
		
	}
	
	
	//Reset player cards
	public void resetCards()
	{
		for(int i=0;i<cards.length;i++)			
			cards[i] = null;
	}
	 
	public PokerPlayer getPlayer()
	{
		return this.player;
	}
	
	public void setPlayer(PokerPlayer spoutPlayer)
	{
		this.player = spoutPlayer;		
	}

	@Override
	public WidgetType getType()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void render()
	{
		// TODO Auto-generated method stub
	}


	public Double getChipsStep()
	{
		return chipsStep;
	}


	public void setChipsStep(Double chipsStep)
	{
		this.chipsStep = chipsStep;
	}

	public Double getChipsTotal()
	{
		return chipsTotal;
	}


	public void setChipsTotal(Double chipsTotal)
	{
		this.chipsTotal = chipsTotal;
	}


	public String getLastActionString()
	{
		return lastActionString;
	}

	public void setLastActionString(String lastActionString)
	{
		this.lastActionString = lastActionString;
	}


	public Boolean getDealer()
	{
		return dealer;
	}


	public void setDealer(Boolean dealer)
	{
		this.dealer = dealer;
	}


	public Boolean getPlay()
	{
		return play;
	}


	public void setPlay(Boolean play)
	{
		this.play = play;
	}
	
	

}
