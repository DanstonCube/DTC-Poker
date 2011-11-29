package com.danstoncube.Poker.combination;

public class PairCombination extends CardCombination {
	
	private int pairValue;
	private int card1=0;
	private int card2=0;
	private int card3=0;
	
	public PairCombination(){
		setTypeCombination(1);
	}
	
	public int compareTo(CardCombination o) {
		return 0;
	}
	
	public void setPairValue(int pPairValue){
		pairValue = pPairValue;
	}
	public int getPairValue(){
		return pairValue;
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
		return "" + pairValue + " " +  pairValue + " "+  card1 + " "+  card2 + " "+  card3;
	}
	
}
