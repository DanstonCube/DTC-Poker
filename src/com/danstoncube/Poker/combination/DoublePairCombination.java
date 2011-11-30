package com.danstoncube.Poker.combination;

import com.danstoncube.Poker.enums.CombinationTypeEnum;

public class DoublePairCombination extends CardCombination {
	
	public DoublePairCombination() {
		setTypeCombination(CombinationTypeEnum.DOUBLEPAIR);
	}
	
	@Override
	public int compareTo(CardCombination arg0)	{
		
		switch(arg0.getTypeCombination())
		{
			case DOUBLEPAIR: 		//ThreeOfAKindCombination
				return 0;

			case HIGHCARD:		
			case PAIR:				//PairCombination
				return 1;			
		}
		
		//Sinon c'est plus fort que nous !
		return -1;
	}


}
