import java.util.ArrayList;
import java.util.List;

import com.danstoncube.poker.enums.CardEnum;
import com.danstoncube.poker.game.combination.CardCombination;
import com.danstoncube.poker.game.combination.Combinations;


public class test {
	 public static void main(String[] args) {
		 
		 
		 
		 List<CardEnum> uneListe = new ArrayList<CardEnum>();
		 
		 uneListe.add(CardEnum.AS_CLUBS);
		 uneListe.add(CardEnum.SEVEN_DIAMONDS);
		 uneListe.add(CardEnum.SIX_CLUBS);
		 uneListe.add(CardEnum.FIVE_CLUBS);
		 uneListe.add(CardEnum.FOUR_CLUBS);
		 uneListe.add(CardEnum.THREE_HEARTS);
		 uneListe.add(CardEnum.THREE_CLUBS);
		 
		 
		 CardCombination uneCombi = Combinations.getBestCombination(uneListe);
		 
		 uneListe.clear();
		 uneListe.add(CardEnum.KING_DIAMONDS);
		 uneListe.add(CardEnum.KING_CLUBS);
		 uneListe.add(CardEnum.KING_HEARTS);
		 uneListe.add(CardEnum.KING_SPADES);
		 uneListe.add(CardEnum.QUEEN_HEARTS);
		 uneListe.add(CardEnum.JACK_CLUBS);
		 uneListe.add(CardEnum.TWO_DIAMONDS);
		 
		 
		 CardCombination uneCombi2 = Combinations.getBestCombination(uneListe);
		 
		
		 System.out.println("main 1 : " + uneCombi.getMessage());
		 System.out.println("main 2 : " + uneCombi2.getMessage());
		 
		 System.out.println("main 1 vs main 2 : " + uneCombi.compareTo(uneCombi2));
		 
		
	 }
}
