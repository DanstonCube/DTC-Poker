import java.util.ArrayList;
import java.util.List;

import com.danstoncube.Poker.combination.CardCombination;
import com.danstoncube.Poker.enums.CardEnum;


public class test {
	 public static void main(String[] args) {
		 
		 List<CardEnum> uneListe = new ArrayList<CardEnum>();
		 
		 uneListe.add(CardEnum.AS_CLUBS);
		 uneListe.add(CardEnum.KING_CLUBS);
		 uneListe.add(CardEnum.QUEEN_CLUBS);
		 uneListe.add(CardEnum.QUEEN_DIAMONDS);
		 uneListe.add(CardEnum.QUEEN_HEARTS);
		 uneListe.add(CardEnum.SEVEN_CLUBS);
		 uneListe.add(CardEnum.TWO_DIAMONDS);
		 
		 CardCombination uneCombi = CardCombination.getBestCombination(uneListe);
		 
		 uneListe.clear();
		 uneListe.add(CardEnum.AS_CLUBS);
		 uneListe.add(CardEnum.JACK_CLUBS);
		 uneListe.add(CardEnum.QUEEN_CLUBS);
		 uneListe.add(CardEnum.QUEEN_DIAMONDS);
		 uneListe.add(CardEnum.QUEEN_HEARTS);
		 uneListe.add(CardEnum.SEVEN_CLUBS);
		 uneListe.add(CardEnum.TWO_DIAMONDS);
		 
		 
		 CardCombination uneCombi2 = CardCombination.getBestCombination(uneListe);
		 
		
		 System.out.println("main 1 : " + uneCombi.getMessage());
		 System.out.println("main 2 : " + uneCombi2.getMessage());
		 
		 System.out.println("main 1 vs main 2 : " + uneCombi.compareTo(uneCombi2));
		 
		
	 }
}
