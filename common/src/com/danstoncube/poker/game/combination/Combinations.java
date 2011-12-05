package com.danstoncube.poker.game.combination;

import java.util.List;

import com.danstoncube.poker.enums.CardEnum;

public class Combinations {

	public static CardCombination getBestCombination(List<CardEnum> pListCard) {
		
		CardCombination aCombination = null;
		
		//On test type par type		
		
		aCombination = QuadCombination.getQuadCombination(pListCard);
		if(aCombination!=null){
			return aCombination;
		}
		
		aCombination = StraightCombination.getStraightCombination(pListCard);
		if(aCombination!=null){
			return aCombination;
		}
		
		aCombination = ThreeOfAKindCombination.getThreeOfAKindCombination(pListCard);
		if(aCombination!=null){
			return aCombination;
		}
		
		aCombination = DoublePairCombination.getDoublePairCombination(pListCard);
		if(aCombination!=null){
			return aCombination;
		}
		
		aCombination = PairCombination.getPairCombination(pListCard);
		if(aCombination!=null){
			return aCombination;
		}
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
}
