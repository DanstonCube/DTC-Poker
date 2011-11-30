package com.danstoncube.Poker.combination;

import com.danstoncube.Poker.enums.CombinationTypeEnum;

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


}
