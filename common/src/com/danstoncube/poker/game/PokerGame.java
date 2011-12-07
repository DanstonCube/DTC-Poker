package com.danstoncube.poker.game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.danstoncube.poker.enums.HandStepEnum;
import com.danstoncube.poker.enums.PlayerActionEnum;


public class PokerGame
{
	//Min-max de joueurs pour demarrer une partie
	private int maxplayers = 8;
	private int minplayers = 2;
	
	// Montant de la cave par defaut
	private double chipsperplayer = 1500.0;
	
	//Identifiant de la partie (ou table)
	private String id = "MD5 hash of multiple variables";
	
	//Partie commencée ?
	private boolean started = false;
	
	//Partie terminée ? 
	private boolean finished = false;
	
	//Tableau de joueurs, taille fixée au demarrage de la partie
	private PokerPlayer[] players;
	
	//Historique des differents tours
	private List<PokerHand> hands = new ArrayList<PokerHand>();
	
	//Main en cours
	private PokerHand hand = null;
	
	//Paquet de carte
	private CardDeck deck = new CardDeck();
	
	
	
	
	/* Listeners */

    private final Collection<PokerGameListener> pokerGameListeners = new ArrayList<PokerGameListener>();
	private PokerPlayer player;
	private int playercount;
	private int indexDealer = -1;
   

    public void addPokerGameListener(PokerGameListener listener) {
    	pokerGameListeners.add(listener);
    }
    
    public void removePokerGameListener(PokerGameListener listener) {
    	pokerGameListeners.remove(listener);
    }
    
    public PokerGameListener[] getPokerGameListeners() {
        return pokerGameListeners.toArray(new PokerGameListener[0]);
    }
	
    
    
    /* Events */
    protected void gameStartChanged() {        
        for(PokerGameListener listener : pokerGameListeners) {
        	listener.onGameStarted();
        }
    }
    
    
    protected void gameStepChanged() {        
        for(PokerGameListener listener : pokerGameListeners) {
        	listener.onNextStep(this.getCurrentHand().getStep());
        }
    }
    
    protected void gameHandChanged(PokerHand newhand) {        
        for(PokerGameListener listener : pokerGameListeners) {
        	listener.onNextHand(newhand);
        }
    }
    
    protected void gamePlayerActionChanged(PokerPlayer pokerPlayer, PlayerActionEnum action, double chipsamount) {        
        for(PokerGameListener listener : pokerGameListeners) {
        	listener.onPlayerAction(pokerPlayer, action, chipsamount);
        }
    }
    
	private void gamePlayerChanged(PokerPlayer pokerPlayer)
	{
		for(PokerGameListener listener : pokerGameListeners) {
        	listener.onPlayerChanged(pokerPlayer);
        }
		
	}

    
    
    
    
    
    

    
    
    
	public PokerGame(int minplayers, int maxplayers)
	{
		this.setMinplayers(minplayers);
		this.maxplayers = maxplayers;
		//this.playercount = 0;
		
		
		//TODO: générateur d'id aléatoire
		this.id = "RANDOM PIF PAF POUF";
		
		//passage en tableau fixe
		this.setPlayers(new PokerPlayer[maxplayers+1]);
	}


	public PokerHand setCurrentHand(PokerHand pokerHand)
	{
		this.hand = pokerHand;
		return this.hand;
	}
	
	public void addHand(PokerHand pokerHand)
	{
		this.hands.add(pokerHand);		
	}
	
	public PokerPlayer getPlayerAt(int playerpos)
	{
		List<PokerPlayer> tmpPlayers = new ArrayList<PokerPlayer>();
		
		for(int i=0;i<maxplayers;i++)
		{
			if(getPlayers()[i]!=null)
				if(getPlayers()[i].isPlaying())
					tmpPlayers.add(getPlayers()[i]);
		}

		return tmpPlayers.get(playerpos);
	}


	
	
	
	public PokerPlayer getNextPlayer()
	{
		int index = getPlayer().getIndex();
		for(int i=0; i<maxplayers; i++)
		{
			index++;
			if(index>=maxplayers)
				index = index - maxplayers;
			
			if(getPlayers()[index]!=null)
				if(getPlayers()[index].isPlaying())
					return getPlayers()[index]; 
			
			
		}

		return null;
	}
	

	
	
	//Callback "action joueur"
	public void playerPlay(PokerPlayer player, PlayerActionEnum action, double chipsamount)
	{
		//Si chipsamount > 0, on enleve les chips au joueur et on les ajoute au pot partiel
		if(chipsamount > 0)
		{
			
			player.removeChips(chipsamount);
			hand.getStep().addPot(chipsamount);
		}
		
		
		switch(action)
		{
			case CHECK:
				//TODO check
			break;
			
			case CALL:
				//TODO call
			break;
								
			case RAISE:
				//TODO raise
			break;
			
			case TIMEOUT:
			case FOLD:				
			default:				
				//timeout = fold
				//TODO action "coucher"				
			break;
		}
		
		
		this.gamePlayerActionChanged(player, action, chipsamount);
		

		//TODO: savoir si tout le monde a joué ou non !
		boolean allPlayersHavePlayed = false; //TODO
		
		
		//Si tout le monde a parler, étape suivante ! (distrib des cartes, ou nouvelle main si c'etait la derniere etape)
		if(allPlayersHavePlayed)			
		{	
			nextStep();
			this.gameStepChanged();
		}
		//Sinon, joueur suivant
		else
		{
			
			nextPlayer();
			//this.gamePlayerChanged();
		}
	}
	
	

	//Retourne le joueur en cours
	public PokerPlayer getCurrentPlayer()
	{
		return getPlayer();
	}

	//Retourne la main en cours
	public PokerHand getCurrentHand()
	{
		return hand;
	}
	
	
	
	
	
	public void addPlayer(PokerPlayer pokerPlayer, int index, double chips)
	{
		//Fixe l'emplacement de la chaise du joueur
		pokerPlayer.setIndex(index);
		
		//Montant par defaut de jetons
		pokerPlayer.setChips(chips);
		
		getPlayers()[index] = pokerPlayer;
		playercount++;
	}


	public String getId()
	{
		return id;
	}


	public void end()
	{
		started = true;
		setFinished(true);
	}
	
	public void begin()
	{
		started = true;
		setFinished(false);
	}


	public int getPlayercount()
	{
		return playercount;
	}


	public PokerPlayer getPlayer()
	{
		return player;
	}

	public void setPlayer(PokerPlayer player)
	{
		this.player = player;
	}

	
	public boolean getStarted()
	{
		return this.started;
	}
	
	public void setStarted(boolean b)
	{
		if((!this.started) && b)
			this.gameStartChanged();
		
		this.started = b;
	}

	public int getMinplayers()
	{
		return minplayers;
	}

	public void setMinplayers(int minplayers)
	{
		this.minplayers = minplayers;
	}

	public double getChipsperplayer()
	{
		return chipsperplayer;
	}

	public void setChipsperplayer(double chipsperplayer)
	{
		this.chipsperplayer = chipsperplayer;
	}

	public boolean isFinished()
	{
		return finished;
	}

	public void setFinished(boolean finished)
	{
		this.finished = finished;
	}

	public List<PokerHand> getHands()
	{
		return hands;
	}

	public void setHands(List<PokerHand> hands)
	{
		this.hands = hands;
	}
	
	public CardDeck getDeck()
	{
		return this.deck;
	}
	public void setDeck(CardDeck cardDeck)
	{
		this.deck = cardDeck;
	}

	public PokerPlayer[] getPlayers()
	{
		return players;
	}

	public void setPlayers(PokerPlayer[] players)
	{
		this.players = players;
	}

	public void start()
	{
		setStarted(true);
		setFinished(false);
	}
	
	public void stop()
	{
		setStarted(false);
		setFinished(true);
	}
	
	//Démarre une nouvelle main
	public PokerHand nextHand()
	{
		setStarted(true);
		
		//Histo du tour
		if(getCurrentHand()!=null)
			addHand(getCurrentHand());
		
		
		//Démarrage d'une hand toute neuve
		PokerHand hand = setCurrentHand(new PokerHand());
		
		//Mélange les cartes
		getDeck().shuffle();

		
		
		indexDealer++;
		
		//Nb de joueurs actifs
		int activePlayersCount = 0;
		
		//compte les joueurs actifs
		for(PokerPlayer curPlayer : getPlayers())
		{
			if(curPlayer==null)
				continue;
			
			//Reset variables "tour"
			curPlayer.setBigBlind(false);
			curPlayer.setSmallBlind(false);
			curPlayer.setDealer(false);
			curPlayer.setPosition(-1);
			
			if(!curPlayer.isPlaying())
				continue;
			
			activePlayersCount++;
		}

		//Calcul des positions clefs
		
		//Pour le modulo, on le fait que sur les joueurs qui sont encore dans la partie
		int posDealer =			(indexDealer + 0) % activePlayersCount;
		int posSmallBlind = 	(indexDealer + 1) % activePlayersCount;
		int posBigBlind = 		(indexDealer + 2) % activePlayersCount;		
		int posStartPlayer =	(indexDealer + 3) % activePlayersCount;
		
		hand.setDealer(getPlayerAt(posDealer));
		hand.setSmallBlindPlayer(getPlayerAt(posSmallBlind));
		hand.setBigBlindPlayer(getPlayerAt(posBigBlind));
		hand.setStartPlayer(getPlayerAt(posStartPlayer));
		
		
		//Boucle sur les joueurs 
		for(PokerPlayer curPlayer : getPlayers())
		{
			if(curPlayer==null)
				continue;
			
			//on skip les joueurs "outs"
			if(!curPlayer.isPlaying())
				continue;
			
			// "efface" les cartes du joueurs 
			curPlayer.resetCards();
			
			//donne deux cartes au joueur
			getDeck().giveCard(curPlayer,2);
			
			//est de petite blinde ? -> mettre la blinde
			if(curPlayer.isSmallBlind())
			{
				curPlayer.removeChips(hand.smallBlind);
				hand.step.addPot(hand.smallBlind);
			}			
			//est de grosse blinde ? -> mettre la blinde
			else if(curPlayer.isBigBlind())
			{
				curPlayer.removeChips(hand.bigBlind);
				hand.step.addPot(hand.bigBlind);
			}
			
		}
		
		setPlayer(getPlayerAt(posStartPlayer));
		
		
		//TODO: notify hand changed
		this.gameHandChanged(hand);

		
		//TODO: notify players turn
		//this.gamePlayerTurnChanged()

		
		return hand;
	}

	
	
	
	//Passe a l'etape suivante de la main (flop / turn / river etc)
	public void nextStep()
	{
		HandStepEnum stepType = hand.getStep().getType();
		
		//on additionne le sous-pot avec le pot		
		hand.addPot(hand.getStep().getPot());
		
		if(stepType == HandStepEnum.BET)
		{
			//passer a flop			
			hand.setStep(new PokerStep(HandStepEnum.FLOP));
			
			//prend 3 cartes dans le deck, et les memorises dans le tableau de la main
			hand.flop[0] = deck.getCard();
			hand.flop[1] = deck.getCard();
			hand.flop[2] = deck.getCard();			
		}
		else if(stepType == HandStepEnum.FLOP)
		{
			//passer a turn
			hand.setStep(new PokerStep(HandStepEnum.TURN));
			hand.flop[3] = deck.getCard();
		}
		else if(stepType == HandStepEnum.TURN)
		{
			//passer a river
			hand.setStep(new PokerStep(HandStepEnum.RIVER));
			hand.flop[4] = deck.getCard();
		}
		else if(stepType == HandStepEnum.RIVER)
		{
			//passer a show
			hand.setStep(new PokerStep(HandStepEnum.SHOW));
		}
		else if(stepType == HandStepEnum.SHOW)
		{
			//nouvelle main			
			//nextHand();
		}		
		
	}


	//Passe au joueur suivant
	public void nextPlayer()
	{		
		
		setPlayer(getNextPlayer());
	
		//TODO: notify player changed
		this.gamePlayerChanged(this.getCurrentPlayer());
	}

	public PokerPlayer getPlayer(String playerName)
	{
		for(PokerPlayer p : players)
		{
			if(p.getPlayerName().compareToIgnoreCase(playerName)==0)
				return p;
		}
		return null;
	}


	
	
	

	
	
}
	