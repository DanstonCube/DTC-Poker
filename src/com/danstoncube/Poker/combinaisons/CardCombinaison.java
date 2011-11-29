package com.danstoncube.Poker.combinaisons;

import java.util.List;

import com.danstoncube.Poker.enums.CardEnum;

public abstract class CardCombinaison implements Comparable<CardCombinaison> {

	private String message;
	private int combiValue; // Valeur de la combinaison 
	private int otherCardValue; // valeur des autres cartes
	
	
	/**
	 * Permet de déterminer la meilleur main d'un joueur 
	 * @param pListCard Liste des cartes table + joueur
	 * @return la combinaison la plus forte en main
	 */
	public static CardCombinaison getBestCombinaison(List<CardEnum> pListCard) {
		
		CardCombinaison aCombinaison = null;
		//On test type par type		
		
		// TODO
		return aCombinaison;
	}


	public int getCombiValue() {
		return combiValue;
	}


	public void setCombiValue(int combiValue) {
		this.combiValue = combiValue;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public int getOtherCardValue() {
		return otherCardValue;
	}


	public void setOtherCardValue(int otherCardValue) {
		this.otherCardValue = otherCardValue;
	}
	
}
