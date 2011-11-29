package com.danstoncube.Poker;

import java.util.ArrayList;
import java.util.List;
import org.getspout.spoutapi.player.SpoutPlayer;

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
	private int indexDealer = 0;
	

	
	PokerGame(int minplayers, int maxplayers)
	{
		this.minplayers = minplayers;
		this.maxplayers = maxplayers;
		
		//TODO: générateur d'id aléatoire
		this.id = "RANDOM PIF PAF POUF";
		
		//passage en tableau fixe
		this.players = new PokerPlayer[maxplayers+1];
	}


	//Démarre une nouvelle main
	@SuppressWarnings("unused")
	public PokerHand startNewHand()
	{
		//Histo du tour
		hands.add(this.hand);
		
		//Mélange les cartes
		deck.shuffle();

		indexDealer++;
		
		
		//Nb de joueurs actifs
		int activePlayersCount = 0;
		
		//compte les joueurs actifs
		for(PokerPlayer curPlayer : players)
		{
			if(!curPlayer.isPlaying())
				continue;
			
			activePlayersCount++;
		}
		
		//Calcul des positions clefs
		//Pour le modulo, on le fait que sur les joueurs qui sont encore dans la partie
		int posDealer =			indexDealer + 0 % activePlayersCount;
		int posBigBlind = 		indexDealer + 1 % activePlayersCount;
		int posSmallBlind = 	indexDealer + 2 % activePlayersCount;
		int posStartPlayer =	indexDealer + 3 % activePlayersCount;
		
		//TODO: calcule les nouvelles positions des joueurs
				
		//Démarrage d'un tout neuf
		this.hand = new PokerHand();	
		
		//Boucle sur les joueurs 
		for(PokerPlayer curPlayer : players)
		{
			//Reset variables "tour"
			curPlayer.setBigBlind(false);
			curPlayer.setSmallBlind(false);
			curPlayer.setDealer(false);
			curPlayer.setPosition(-1);
			
			
			//on skip les joueurs "outs"
			if(!curPlayer.isPlaying())
				continue;
			
			//TODO: recalculer player.position =
			//TODO: recalculer player.dealer =
			//TODO: recalculer player.smallblind = 
			//TODO: recalculer player.bigblind = 
			
			/*
			curPlayer.setBigBlind( );
			curPlayer.setSmallBlind( );
			curPlayer.setDealer( );
			*/
			
			// "efface" les cartes du joueurs 
			curPlayer.resetCards();
			
			//donne deux cartes au joueur
			deck.giveCard(curPlayer);
			deck.giveCard(curPlayer);
			
			
			
			//TODO: est de petite blinde ? -> mettre la blinde
			
			//TODO: est de grosse blinde ? -> mettre la blinde
			
			
		}
		
		
		
		//TODO: ICI, Debut du tour, au joueur suivant la big blinde de commencer !
		
		
		
		return hand;
	}
	
	//Retourne la main en cours
	public PokerHand getCurrentHand()
	{
		return hand;
	}
	
	//Ajoute un joueur a la table
	public void addPlayer(SpoutPlayer player, int position, double chips)
	{
		PokerPlayer pplayer =  new PokerPlayer(player);
		
		//Fixe l'emplacement de la chaise du joueur
		pplayer.setPosition(position);
		
		//Montant par defaut de jetons
		pplayer.setChips(chips);
		
		players[position] = pplayer;		
	}	
	


	public String getId()
	{
		return id;
	}
	
	
}
	