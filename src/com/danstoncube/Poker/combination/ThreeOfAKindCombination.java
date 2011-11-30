package com.danstoncube.Poker.combination;

import com.danstoncube.Poker.enums.CombinationTypeEnum;

public class ThreeOfAKindCombination extends CardCombination {
	
	public ThreeOfAKindCombination(){
		setTypeCombination(CombinationTypeEnum.THREEOFAKIND);
	}
	
	public int compareTo(CardCombination arg0)	{

		return 0;
	}
	
	public boolean isComplet()
	{
		return false;		
	}
	
	

}
