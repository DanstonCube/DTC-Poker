package com.danstoncube.poker.game.combination;

import com.danstoncube.poker.enums.CardEnum;
import com.danstoncube.poker.enums.CombinationTypeEnum;

public abstract class CardCombination implements Comparable<CardCombination> {

	private String message;
	private CombinationTypeEnum typeCombination;
	private CardEnum[] cardArray ;
	private int cCardArray;
	
	/**
	 * Permet de déterminer la meilleur main d'un joueur 
	 * @param pListCard Liste des cartes table + joueur
	 * @return la combinaison la plus forte en main
	 */
	
	public CardCombination(){
		cardArray = new CardEnum[5];
		cCardArray = 0;
	}


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
	
	public boolean isComplet(){
		return cCardArray == 5;
	}
	
	public void addCard(CardEnum pCard){
		cardArray[cCardArray++]=pCard;
	}
	
}
