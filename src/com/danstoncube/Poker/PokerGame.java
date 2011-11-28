package com.danstoncube.Poker;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.getspout.spoutapi.player.SpoutPlayer;

public class PokerGame
{
	
	public int maxplayers = 8;
	public int minplayers = 2;
	
	public String id = "MD5 hash of multiple variables";
	
	public boolean started = false;
	public boolean finished = false;
	
	
	public List<PokerPlayer> players = new ArrayList<PokerPlayer>();
	public List<PokerHand> hands = new ArrayList<PokerHand>();
	
	//Main en cours
	public PokerHand hand = null;
	
	public CardDeck deck = new CardDeck();
	
	
	
	
	PokerGame()
	{
		//TODO: générateur d'id aléatoire
		this.id = "RANDOM PIF PAF POUF";
	}
	
	
	//Démarre une nouvelle main
	public PokerHand startNewHand()
	{
		PokerHand newhand = new PokerHand();
		
		ListIterator<PokerPlayer> playerIterator = players.listIterator();
		
		PokerPlayer curPlayer = playerIterator.next();
		
		
		//Boucle sur les joueurs 
		while(curPlayer != null)
		{
			// "efface" les cartes du joueurs 
			curPlayer.resetCards();
			
			//TODO: décaler la position du joueur
			
			//TODO: verifier les blindes
			
			//TODO: distribuer les cartes aux joueurs

			//TODO: donner deux carte au joueur
			
			curPlayer = playerIterator.next();
		}
		
		
		//TODO: hand.setDealer(player);
		//TODO: hand.setSmallBlind(int);
		//TODO: hand.setBigBlind(int);
		
		hands.add(newhand);
		
		this.hand = newhand;
		return newhand;
	}
	
	//Retourne la main en cours
	public PokerHand getCurrentHand()
	{
		return hand;
	}
	
	//Ajoute un joueur a la table
	public void addPlayer(SpoutPlayer player)
	{
		players.add(new PokerPlayer(player));
	}	
	public void addPlayer(PokerPlayer player)
	{
		players.add(player);
	}


	public String getId()
	{
		return id;
	}
	
	
}
	