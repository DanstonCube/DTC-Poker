package com.danstoncube.poker.game.combination;

import java.util.Collections;
import java.util.Comparator;
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
	
	/*
	 * A deplacer dans l'enum ?
	 */
	public static int compareListOfEnum(CardEnum[] pListe1,CardEnum[] pListe2){
		int ret=0;		
		int max = Math.min(pListe1.length, pListe2.length);		
		for(int i=0;ret == 0 && i < max ; i++ ){
			ret = pListe1[i].compare(pListe2[i]);
		}
		return ret;
	}
	
	
	public static void sort(List<CardEnum> pList){
		
		Collections.sort(pList, new Comparator<CardEnum>(){

			public int compare(CardEnum o1, CardEnum o2) {
				return -o1.compare(o2);
			}
			
		});
		
	}
	
	
	
	
	
	
	
	
}
