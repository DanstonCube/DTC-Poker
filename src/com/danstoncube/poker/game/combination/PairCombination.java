package com.danstoncube.poker.game.combination;

import java.util.List;

import com.danstoncube.poker.enums.CardEnum;
import com.danstoncube.poker.enums.CombinationTypeEnum;

public class PairCombination extends CardCombination {
	
	private int pairValue;
	private int card1=0;
	private int card2=0;
	private int card3=0;
	
	public PairCombination(){
		setTypeCombination(CombinationTypeEnum.PAIR);
	}
	
	public int compareTo(CardCombination o) {
		if(this.getTypeCombination().equals(o.getTypeCombination())){
			PairCombination anotherPair = (PairCombination)o;
			if(pairValue > anotherPair.getPairValue())
				return 1;
			if(pairValue < anotherPair.getPairValue())
				return -1;
			if(card1 > anotherPair.getCard1())
				return 1;
			if(card1 < anotherPair.getCard1())
				return -1;
			if(card2 > anotherPair.getCard2())
				return 1;
			if(card2 < anotherPair.getCard2())
				return -1;
			if(card3 > anotherPair.getCard3())
				return 1;
			if(card3 < anotherPair.getCard3())
				return -1;
			return 0;
		}
		return this.getTypeCombination().compareTo(o.getTypeCombination());			
	}
	
	public void setPairValue(int pPairValue){
		pairValue = pPairValue;
	}
	public int getPairValue(){
		return pairValue;
	}
	
	public int getCard1() {
		return card1;
	}

	public int getCard2() {
		return card2;
	}

	public int getCard3() {
		return card3;
	}

	public void addCardValue(int pValue){
		if(card1==0)
			card1 = pValue;
		else if(card2==0)
			card2 = pValue;
		else if(card3==0)
			card3 = pValue;
	}	
	
	
	public boolean isComplet()
	{
		return card3!=0;		
	}
	
	public String getMessage(){
		return "Pair : " + pairValue + " " +  pairValue + " "+  card1 + " "+  card2 + " "+  card3;
	}
	
	public static PairCombination getPairCombination(List<CardEnum> pListCards){
		PairCombination aPair = null;
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
}
