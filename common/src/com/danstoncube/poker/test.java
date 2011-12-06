package com.danstoncube.poker;

import java.util.ArrayList;
import java.util.List;

import com.danstoncube.poker.enums.CardEnum;
import com.danstoncube.poker.game.combination.CardCombination;
import com.danstoncube.poker.game.combination.Combinations;


public class test {
	 public static void main(String[] args) {
		 
		 
		 		 
		 
		 List<CardEnum> tapis = new ArrayList<CardEnum>();		 
		 tapis.add(CardEnum.AS_CLUBS);
		 tapis.add(CardEnum.KING_CLUBS);
		 tapis.add(CardEnum.QUEEN_CLUBS);
		 tapis.add(CardEnum.TWO_DIAMONDS);
		 tapis.add(CardEnum.THREE_CLUBS);
		 
		 List<CardEnum> main1 = new ArrayList<CardEnum>();
		 main1.add(CardEnum.TEN_DIAMONDS);
		 main1.add(CardEnum.JACK_SPADES);
		 
		 main1.addAll(tapis);		 
		 Combinations.sort(main1);
		 
		 List<CardEnum> main2 = new ArrayList<CardEnum>();
		 main2.add(CardEnum.FIVE_HEARTS);
		 main2.add(CardEnum.FOUR_CLUBS);
		 
		 main2.addAll(tapis);		 
		 Combinations.sort(main2);
		 
		 
		 CardCombination uneCombi1 = Combinations.getBestCombination(main1);
		 CardCombination uneCombi2 = Combinations.getBestCombination(main2);
		 
		
		 System.out.println("main 1 : " + uneCombi1.getMessage());
		 System.out.println("main 2 : " + uneCombi2.getMessage());
		 
		 System.out.println("main 1 vs main 2 : " + uneCombi1.compareTo(uneCombi2));
		 
		
	 }
}
