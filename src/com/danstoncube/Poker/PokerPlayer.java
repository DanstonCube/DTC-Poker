package com.danstoncube.Poker;

import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.SpoutPlayer;

public class PokerPlayer
{
	public SpoutPlayer _spoutplayer = null;
	
	public int chipscount = 0;
	
	private boolean afk = false;
	
	public Card[] cards = new Card[2];
	
	
	PokerPlayer(SpoutPlayer player)
	{
		this._spoutplayer = player;	
		resetCards();
	}
	
	
	// Give player one card, can be called two times only
	public void giveCard(Card card)
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

	
	
	
}
