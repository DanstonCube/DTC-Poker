package com.danstoncube.Poker.combination;

import com.danstoncube.Poker.enums.CombinationTypeEnum;

public class ThreeOfAKindCombination extends CardCombination {
	
	public ThreeOfAKindCombination(){
		setTypeCombination(CombinationTypeEnum.THREEOFAKIND);
	}
	
	@Override
	public int compareTo(CardCombination arg0)	{

		switch(arg0.getTypeCombination())
		{
			case THREEOFAKIND: 		//ThreeOfAKindCombination
				return 0;

			case HIGHCARD:
			case DOUBLEPAIR:		
			case PAIR:				//PairCombination
				return 1;			
		}
		
		//Sinon c'est plus fort que nous !
		return -1;
	}
	
	

}
