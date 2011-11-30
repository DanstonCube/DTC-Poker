import java.util.ArrayList;
import java.util.List;

import com.danstoncube.Poker.combination.CardCombination;
import com.danstoncube.Poker.combination.Combinations;
import com.danstoncube.Poker.enums.CardEnum;
import com.danstoncube.Poker.enums.CombinationTypeEnum;


public class test {
	 public static void main(String[] args) {
		 
		 List<CardEnum> uneListe = new ArrayList<CardEnum>();
		 
		 uneListe.add(CardEnum.AS_CLUBS);
		 uneListe.add(CardEnum.AS_DIAMONDS);
		 uneListe.add(CardEnum.QUEEN_CLUBS);
		 uneListe.add(CardEnum.FIVE_CLUBS);
		 uneListe.add(CardEnum.THREE_CLUBS);
		 uneListe.add(CardEnum.TWO_CLUBS);
		 uneListe.add(CardEnum.TWO_DIAMONDS);
		 
		 CardCombination uneCombi = CardCombination.getBestCombination(uneListe);
		 
		 uneListe.clear();
		 uneListe.add(CardEnum.AS_CLUBS);
		 uneListe.add(CardEnum.AS_DIAMONDS);
		 uneListe.add(CardEnum.QUEEN_CLUBS);
		 uneListe.add(CardEnum.SEVEN_CLUBS);
		 uneListe.add(CardEnum.FOUR_CLUBS);
		 uneListe.add(CardEnum.TWO_CLUBS);
		 uneListe.add(CardEnum.TWO_DIAMONDS);
		 
		 
		 CardCombination uneCombi2 = CardCombination.getBestCombination(uneListe);
		 
		
		 System.out.println("main 1 : " + uneCombi.getMessage());
		 System.out.println("main 2 : " + uneCombi2.getMessage());
		 
		 System.out.println("main 1 vs main 2 : " + uneCombi.compareTo(uneCombi2));
		 
		
	 }
}
