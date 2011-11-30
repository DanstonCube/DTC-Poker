package com.danstoncube.Poker.combination;

import java.util.List;

import com.danstoncube.Poker.enums.CardEnum;

public class Combinations {

	public static PairCombination getPairCombination(List<CardEnum> pListCards){
		PairCombination aPair = null;
		// La liste doit être triée descroissante
		
		CardEnum firstCard = pListCards.get(0);
		CardEnum secondCard = null; 
		for(int i = 1 ; i < pListCards.size();i++){
			secondCard = pListCards.get(i);
			if(firstCard.getValue() == secondCard.getValue()){
				break;
			}
			firstCard = secondCard;
		}
		if(firstCard!=secondCard){
			// on stop avant
			aPair = new PairCombination();
			aPair.setPairValue(firstCard.getValue());
			for(int i = 0 ; i < pListCards.size() && !aPair.isComplet();i++){
				if(pListCards.get(i).getValue() != firstCard.getValue()){
					aPair.addCardValue(pListCards.get(i).getValue());
				}
			}
		}
		
		return aPair;
	}
	
	public static DoublePairCombination getDoublePairCombination(List<CardEnum> pListCards){
		DoublePairCombination aDPair = null;
		// La liste doit être triée descroissante
		int firstPair=0;
		int secondPair=0;
		
		CardEnum firstCard = pListCards.get(0);
		CardEnum secondCard = null;
		
		// en cas de brelan, on detecte deux pairs
		for(int i = 1 ; i < pListCards.size();i++){
			secondCard = pListCards.get(i);
			if(firstCard.getValue() == secondCard.getValue()){
				if(firstPair==0){
					firstPair = firstCard.getValue();
				}else if(secondPair==0){
					secondPair = firstCard.getValue();
					break;
				}
			}
			firstCard = secondCard;
		}
		if(firstCard!=secondCard){
			// on stop avant
			aDPair = new DoublePairCombination(firstPair,secondPair);
			for(int i = 0 ; i < pListCards.size() && !aDPair.isComplet();i++){
				CardEnum aCard = pListCards.get(i);				
				if(aCard.getValue() != firstPair && aCard.getValue()!= secondPair){
						aDPair.setHightcardValue(aCard.getValue());					
				}	
			}
		}
		return aDPair;
	}
	
	
	public static ThreeOfAKindCombination getThreeOfAKindCombination(List<CardEnum> pListCards){
		ThreeOfAKindCombination aCombi = null;
		int sameCardCount = 0;
		CardEnum firstCard = pListCards.get(0);
		CardEnum secondCard = null;
		
		for(int i = 1 ; i < pListCards.size();i++){
			secondCard = pListCards.get(i);
			if(firstCard.getValue() == secondCard.getValue()){
				sameCardCount++;
				if(sameCardCount == 2){
					break;
				}				
			}else{
				sameCardCount = 0;
			}
			firstCard = secondCard;
		}
		if(sameCardCount == 2){
			// on stop avant
			aCombi = new ThreeOfAKindCombination(firstCard.getValue());
			for(int i = 0 ; i < pListCards.size() && !aCombi.isComplet();i++){
				CardEnum aCard = pListCards.get(i);				
				if(aCard.getValue() != aCombi.getValueTreeOfAKind()){
					aCombi.addCardValue(aCard.getValue());
				}	
			}
		}
		return aCombi;
	}
	
}
