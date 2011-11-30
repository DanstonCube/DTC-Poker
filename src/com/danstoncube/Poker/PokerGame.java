package com.danstoncube.Poker;

import java.util.ArrayList;
import java.util.List;
import org.getspout.spoutapi.player.SpoutPlayer;

import com.danstoncube.Poker.enums.HandStepEnum;
import com.danstoncube.Poker.enums.PlayerActionEnum;

public class PokerGame
{
	//Min-max de joueurs pour demarrer une partie
	public int maxplayers = 8;
	public int minplayers = 2;
	
	// Montant de la cave par defaut
	public double chipsperplayer = 1500.0;
	
	//Identifiant de la partie (ou table)
	public String id = "MD5 hash of multiple variables";
	
	//Partie commencée ?
	public boolean started = false;
	
	//Partie terminée ? 
	public boolean finished = false;
	
	//Tableau de joueurs, taille fixée au demarrage de la partie
	public PokerPlayer[] players;
	
	//Historique des differents tours
	public List<PokerHand> hands = new ArrayList<PokerHand>();
	
	//Main en cours
	public PokerHand hand = null;
	
	//Paquet de carte
	public CardDeck deck = new CardDeck();
	
	//Compteur pour les modulos (et les blindes ???)
	private int indexDealer = -1;
	
	//Joueur en cours
	private PokerPlayer player = null;
	
	private int playercount = 0;
	

	
	
	
	
	PokerGame(int minplayers, int maxplayers)
	{
		this.minplayers = minplayers;
		this.maxplayers = maxplayers;
		this.playercount = 0;
		
		
		//TODO: générateur d'id aléatoire
		this.id = "RANDOM PIF PAF POUF";
		
		//passage en tableau fixe
		this.players = new PokerPlayer[maxplayers+1];
	}


	//Démarre une nouvelle main
	public PokerHand newHand()
	{
		//Histo du tour
		if(this.hand!=null)
			hands.add(this.hand);
		
		
		//Démarrage d'une hand toute neuve
		this.hand = new PokerHand();
		
		//Mélange les cartes
		deck.shuffle();

		
		indexDealer++;
		
		//Nb de joueurs actifs
		int activePlayersCount = 0;
		
		//compte les joueurs actifs
		for(PokerPlayer curPlayer : players)
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
		
		
		
		
		//TODO: calcule les nouvelles positions des joueurs
				
	
		
		hand.setDealer(getPlayerAt(posDealer));
		hand.setSmallBlindPlayer(getPlayerAt(posSmallBlind));
		hand.setBigBlindPlayer(getPlayerAt(posBigBlind));
		hand.setStartPlayer(getPlayerAt(posStartPlayer));
		
		//Boucle sur les joueurs 
		for(PokerPlayer curPlayer : players)
		{
			if(curPlayer==null)
				continue;
			
			//on skip les joueurs "outs"
			if(!curPlayer.isPlaying())
				continue;
			
			// "efface" les cartes du joueurs 
			curPlayer.resetCards();
			
			//donne deux cartes au joueur
			deck.giveCard(curPlayer,2);
			
			//TODO: est de petite blinde ? -> mettre la blinde
			
			//TODO: est de grosse blinde ? -> mettre la blinde
			
			//TODO: est-ce au joueur de jouer ??? si oui, notification gui
		}
		
		player = getPlayerAt(posStartPlayer);
		
		return hand;
	}
	
	
	private PokerPlayer getPlayerAt(int playerpos)
	{
		List<PokerPlayer> tmpPlayers = new ArrayList<PokerPlayer>();
		
		for(int i=0;i<maxplayers;i++)
		{
			if(players[i]!=null)
				if(players[i].isPlaying())
					tmpPlayers.add(players[i]);
		}

		return tmpPlayers.get(playerpos);
	}


	//Passe au joueur suivant
	public void nextPlayer()
	{		
		//PokerServer.notifyPlayerEndTurn(this.player);		
		this.player = getNextPlayer();
		//PokerServer.notifyPlayerTurn(this.player);		
		
		//TODO: attente réponse joueur ou timeout
	}
	
	
	private PokerPlayer getNextPlayer()
	{
		int index = player.getIndex();
		for(int i=0; i<maxplayers; i++)
		{
			index++;
			if(index>=maxplayers)
				index = index - maxplayers;
			
			if(players[index]!=null)
				if(players[index].isPlaying())
					return players[index]; 
			
			
		}

		return null;
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
			newHand();
		}		
		
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
		

		//TODO: savoir si tout le monde a joué ou non !
		boolean allPlayersHavePlayed = false; //TODO
		
		
		//Si tout le monde a parler, étape suivante ! (distrib des cartes, ou nouvelle main si c'etait la derniere etape)
		if(allPlayersHavePlayed)			
		{	
			nextStep();
			
		}
		//Sinon, joueur suivant
		else
		{
			nextPlayer();
		}
	}
	
	
	//Retourne le joueur en cours
	public PokerPlayer getCurrentPlayer()
	{
		return player;
	}

	//Retourne la main en cours
	public PokerHand getCurrentHand()
	{
		return hand;
	}
	
	
	
	//Ajoute un joueur a la table
	public void addPlayer(SpoutPlayer spoutPlayer, int index, double chips)
	{
		PokerPlayer pokerplayer = new PokerPlayer(spoutPlayer);
		addPlayer(pokerplayer, index, chips);	
	}	
	
	public void addPlayer(PokerPlayer pokerPlayer, int index, double chips)
	{
		//Fixe l'emplacement de la chaise du joueur
		pokerPlayer.setIndex(index);
		
		//Montant par defaut de jetons
		pokerPlayer.setChips(chips);
		
		players[index] = pokerPlayer;
		playercount++;
	}


	public String getId()
	{
		return id;
	}


	public void end()
	{
		started = true;
		finished = true;
	}
	
	public void begin()
	{
		started = true;
		finished = false;
	}


	public int getPlayercount()
	{
		return playercount;
	}


	public PokerPlayer getPlayer()
	{
		return player;
	}
	
	
}
	