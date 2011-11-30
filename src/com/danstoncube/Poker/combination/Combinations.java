package com.danstoncube.Poker.combination;

import java.util.List;

import com.danstoncube.Poker.enums.CardEnum;

public class Combinations {

	public static PairCombination getPairCombination(List<CardEnum> pListCards){
	
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
			PairCombination aPair = new PairCombination();
			aPair.setPairValue(firstCard.getValue());
			int cpt = 0;
			while(!aPair.isComplet()){
				if(pListCards.get(cpt).getValue() != firstCard.getValue()){
					aPair.addCardValue(pListCards.get(cpt).getValue());
				}
				cpt++;
			}
			return aPair;			
		}
		
		return null;
	}
	
	public static DoublePairCombination getDoublePairCombination(List<CardEnum> pListCards){
		
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
			DoublePairCombination aDPair = new DoublePairCombination(firstPair,secondPair);
			for(CardEnum aCard : pListCards){
				if(aDPair.isComplet()){
					break;					
				}
				if(aCard.getValue() != firstPair && aCard.getValue()!= secondPair){
						aDPair.setHightcardValue(aCard.getValue());					
				}	
			}
			return aDPair;
		}
		return null;
	}
	
}
