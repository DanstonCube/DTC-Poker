package com.danstoncube.poker.game;

import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.danstoncube.poker.enums.CardEnum;
import com.danstoncube.poker.server.ServerCustomSounds;

@SuppressWarnings("unused")
public class PokerPlayer
{
	public SpoutPlayer _spoutplayer = null;
	
	private double 	chips 		= 0.0;	
	private boolean afk 		= false;
	private boolean dealer 		= false;
	private boolean smallBlind 	= false;
	private boolean bigBlind 	= false;
	private int 	index 		= 0;
	private int 	position 	= -1;
	private boolean playing 	= true;
	
	private String dgbplayername = ""; 
	
	public CardEnum[] cards = new CardEnum[2];
	
	//Pour les tests uniquement
	public PokerPlayer(String player)
	{
		this.dgbplayername = player;
		this._spoutplayer = null;	
		resetCards();
	}
	
	PokerPlayer(SpoutPlayer player)
	{
		this._spoutplayer = player;	
		resetCards();
	}
	
	
	public String getPlayerName()
	{		
		if(_spoutplayer==null)
			return dgbplayername;
					
		return _spoutplayer.getName();		
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
		return playing;
	}

	public void notifyPlayersCards()
	{
		//TODO: envoyer un achievement "Paire de huit" etc etc
	}
	
	public void notifyTurn()
	{

		System.out.println("A toi de jouer " + getPlayerName());
		
		ServerCustomSounds.playYourTurnSound(_spoutplayer);
		
		//envoye un bip au joueur lui signalant que c'est a lui de jouer
		//(commenté pour le debug sans spout ni bukkit)
		
		//SpoutManager.getSoundManager().playCustomSoundEffect(Poker.getInstance(), _spoutplayer, "URL DU SON", false);
	}

	
	public int getPosition()
	{
		return this.position;		
	}

	public void setPosition(int i)
	{
		this.position  = i;		
	}


	public void setChips(double chips)
	{
		this.chips = chips;
	}

	public double getChips()
	{
		return this.chips;
	}
	
	public void addChips(double chipsamount)
	{
		this.chips += chipsamount;		
	}

	public void removeChips(double chipsamount)
	{
		this.chips -= chipsamount;		
	}

	public void setIndex(int index)
	{
		this.index = index;		
	}
	
	public int getIndex()
	{
		return this.index;
	}

	
	
	
	
	
}
