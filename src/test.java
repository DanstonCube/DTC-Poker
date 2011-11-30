import java.util.ArrayList;
import java.util.List;

import com.danstoncube.Poker.combination.CardCombination;
import com.danstoncube.Poker.combination.Combinations;
import com.danstoncube.Poker.enums.CardEnum;


public class test {
	 public static void main(String[] args) {
		 
		 List<CardEnum> uneListe = new ArrayList<CardEnum>();
		 
		 uneListe.add(CardEnum.AS_CLUBS);
		 uneListe.add(CardEnum.KING_CLUBS);
		 uneListe.add(CardEnum.TWO_CLUBS);
		 uneListe.add(CardEnum.EIGHT_DIAMONDS);
		 uneListe.add(CardEnum.FOUR_CLUBS);
		 uneListe.add(CardEnum.THREE_DIAMONDS);
		 uneListe.add(CardEnum.TWO_DIAMONDS);
		 
		 CardCombination uneCombi = Combinations.getPairCombination(uneListe);
		 
		 System.out.println(uneCombi.getMessage());
		 
		
	 }
}
