package com.danstoncube.poker.game.combination;

import com.danstoncube.poker.enums.CombinationTypeEnum;

public abstract class CardCombination implements Comparable<CardCombination> {

	private String message;
	private CombinationTypeEnum typeCombination = CombinationTypeEnum.HIGHCARD;
	private int otherCardValue; // valeur des autres cartes
	
	
	/**
	 * Permet de déterminer la meilleur main d'un joueur 
	 * @param pListCard Liste des cartes table + joueur
	 * @return la combinaison la plus forte en main
	 */
	


	public CombinationTypeEnum getTypeCombination() {
		return typeCombination;
	}


	public void setTypeCombination(CombinationTypeEnum typeCombination) {
		this.typeCombination = typeCombination;
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
	
	public abstract boolean isComplet();
	
}