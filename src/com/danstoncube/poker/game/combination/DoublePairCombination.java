package com.danstoncube.poker.game.combination;

import java.util.List;

import com.danstoncube.poker.enums.CardEnum;
import com.danstoncube.poker.enums.CombinationTypeEnum;

public class DoublePairCombination extends CardCombination {
	
	private int firstPairValue;
	private int secondPairValue;
	private int hightcardValue;
	
	public DoublePairCombination(int pFirstPairValue, int pSecondPairValue) {
		super();
		setTypeCombination(CombinationTypeEnum.DOUBLEPAIR);
		firstPairValue = pFirstPairValue;
		secondPairValue = pSecondPairValue;
		
	}
	
	public int compareTo(CardCombination o) {
		if(this.getTypeCombination().equals(o.getTypeCombination())){
			DoublePairCombination anotherPair = (DoublePairCombination)o;
			if(firstPairValue > anotherPair.getFirstPairValue())
				return 1;
			if(firstPairValue < anotherPair.getFirstPairValue())
				return -1;
			if(secondPairValue > anotherPair.getSecondPairValue())
				return 1;
			if(secondPairValue < anotherPair.getSecondPairValue())
				return -1;
			if(hightcardValue > anotherPair.getHightcardValue())
				return 1;
			if(hightcardValue < anotherPair.getHightcardValue())
				return -1;
			return 0;
		}
		return this.getTypeCombination().compareTo(o.getTypeCombination());
	}
	
	public boolean isComplet()
	{
		return hightcardValue!=0 && firstPairValue != 0 && secondPairValue!=0 ;		
	}

	public int getFirstPairValue() {
		return firstPairValue;
	}

	public void setFirstPairValue(int firstPairValue) {
		this.firstPairValue = firstPairValue;
	}

	public int getHightcardValue() {
		return hightcardValue;
	}

	public void setHightcardValue(int hightcardValue) {
		this.hightcardValue = hightcardValue;
	}

	public int getSecondPairValue() {
		return secondPairValue;
	}

	public void setSecondPairValue(int secondPairValue) {
		this.secondPairValue = secondPairValue;
	}
	
	public String getMessage(){
		return "Double Pair : " + firstPairValue + " " +  firstPairValue + " "+  secondPairValue + " "+  secondPairValue + " "+  hightcardValue;
	}
	
	public static DoublePairCombination getDoublePairCombination(List<CardEnum> pListCards){
		DoublePairCombination aDPair = null;
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


}
