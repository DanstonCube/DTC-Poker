package com.danstoncube.Poker.combination;

import java.util.List;

import com.danstoncube.Poker.enums.CardEnum;

public class Combinations {

	public static PairCombination getPairCombination(List<CardEnum> pListCards){
	
		// La liste doit �tre tri�e descroissante
		
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
	
}