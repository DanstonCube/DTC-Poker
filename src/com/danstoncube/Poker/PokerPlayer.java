package com.danstoncube.Poker;

import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.danstoncube.Poker.enums.CardEnum;

public class PokerPlayer
{
	public SpoutPlayer _spoutplayer = null;
	
	public int chipscount = 0;
	
	private boolean afk = false;
	private boolean dealer = false;
	private boolean smallBlind = false;
	private boolean bigBlind = false;
	
	
	
	public CardEnum[] cards = new CardEnum[2];

	public int position = -1;
	
	
	PokerPlayer(SpoutPlayer player)
	{
		this._spoutplayer = player;	
		resetCards();
	}
	
	
	// Give player one card, can be called two times only
	public void giveCard(CardEnum card)
	{
		if(cards[0]==null)
			cards[0] = card;
		else if(cards[1] == null)
			cards[1] = card;
	}
	
	public void resetCards()
	{
		cards[0]=null;
		cards[1]=null;
	}
	
	
	
	public boolean isAfk()
	{
		return this.afk;
	}
	
	public boolean isDealer()
	{
		return this.dealer;
	}
	
	public boolean isSmallBlind()
	{
		return this.smallBlind;
	}
	
	public boolean isBigBlind()
	{
		return this.bigBlind;
	}
	
	public void setDealer(boolean b)
	{
		this.dealer = b;		
	}
	public void setSmallBlind(boolean b)
	{
		this.smallBlind = b;		
	}
	public void setBigBlind(boolean b)
	{
		this.bigBlind = b;		
	}
	
	
	
	public void setAfk(boolean afk)
	{
		this.afk = afk;
	}
	
	
	//Le joueur a t'il des cartes en main ? 
	public boolean isPlaying()
	{
		return false;
	}

	public void notifyPlayersCards()
	{
		//TODO: envoyer un achievement "Paire de huit" etc etc
	}
	
	public void notifyPlayersTurn()
	{
		//TODO: envoyer un bip au joueur lui signalant que c'est a lui de jouer
		SpoutManager.getSoundManager().playCustomSoundEffect(Poker.getInstance(), _spoutplayer, "URL DU SON", false);
	}

	
	public int getPosition()
	{
		return this.position;		
	}

	public void setPosition(int i)
	{
		this.position  = i;		
	}


	
	
	
	
}
