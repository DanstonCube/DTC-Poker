package com.danstoncube.Poker.combination;

import java.util.List;

import com.danstoncube.Poker.enums.CardEnum;
import com.danstoncube.Poker.enums.CombinationTypeEnum;

public abstract class CardCombination implements Comparable<CardCombination> {

	private String message;
	private CombinationTypeEnum typeCombination = CombinationTypeEnum.HIGHCARD;
	private int otherCardValue; // valeur des autres cartes
	
	
	/**
	 * Permet de déterminer la meilleur main d'un joueur 
	 * @param pListCard Liste des cartes table + joueur
	 * @return la combinaison la plus forte en main
	 */
	public static CardCombination getBestCombination(List<CardEnum> pListCard) {
		
		CardCombination aCombination = null;
		
		//On test type par type		
		
		
		aCombination = Combinations.getPairCombination(pListCard);
		if(aCombination!=null)
			return aCombination;
		
		/*
		 * 
		 
		 Miko: Pas tres propre :(
		 
		aCombination = Combinations.getPairCombination(pListCard);
		if(aCombination!=null)
			return aCombination;
		
		aCombination = Combinations.getPairCombination(pListCard);
		if(aCombination!=null)
			return aCombination;
		
		
		aCombination = Combinations.getPairCombination(pListCard);
		if(aCombination!=null)
			return aCombination;
		
		
		aCombination = Combinations.getPairCombination(pListCard);
		if(aCombination!=null)
			return aCombination;
		*/
		
		
		return null;
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


	public int getOtherCardValue() {
		return otherCardValue;
	}


	public void setOtherCardValue(int otherCardValue) {
		this.otherCardValue = otherCardValue;
	}
	
}
