package com.danstoncube.poker.game.combination;

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
	
}
