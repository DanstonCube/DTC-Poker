package com.danstoncube.poker.game.combination;

import java.util.List;

import com.danstoncube.poker.enums.CardEnum;
import com.danstoncube.poker.enums.CombinationTypeEnum;

public class StraightCombination extends CardCombination {

	private int straightHighCardValue;

	public StraightCombination (int pStraightHighCardValue){
		super();
		this.setTypeCombination(CombinationTypeEnum.STRAIGHT);
		straightHighCardValue = pStraightHighCardValue;
	}

	@Override
	public boolean isComplet() {
		return true;
	}

	public int compareTo(CardCombination o) {
		if(this.getTypeCombination().equals(o.getTypeCombination())){
			StraightCombination anotherPair = (StraightCombination)o;
			if(straightHighCardValue != anotherPair.getStraightHighCardValue()){
				return straightHighCardValue - anotherPair.getStraightHighCardValue();
			}
			return 0;
		}
		return this.getTypeCombination().compareTo(o.getTypeCombination());
	}

	
	public static StraightCombination getStraightCombination(List<CardEnum> pListCards){
		StraightCombination aCombi = null;
		
		int highCard = 0;
		int countCard = 1;
		// Sortie de boucle plus complexe : sort si la carte suivante ne fait pas parti de la suite
		// Permet de savoir si suite à l'AS
		for(int i = 0; i < pListCards.size();i++){
			if(pListCards.get(i).getValue() == highCard-countCard ){
				countCard++;				
			}
			else if (pListCards.get(i).getValue() != highCard-(countCard-1) ){
				if(countCard >=5){
					// Pas beau le break mais bon
					break;
				}
				countCard = 1;
				highCard = pListCards.get(i).getValue();
			}
		}
		// cas particulier de l'AS
		if(countCard >= 4){
			// en dur parce que pas d'Enum sur les cards !
			if(highCard - countCard == 1 && pListCards.get(0).getValue() == 14){
				highCard =pListCards.get(0).getValue();
				countCard ++;
			}
		}
		
		
		if(countCard >= 5){
			aCombi = new StraightCombination(highCard);			
		}
		return aCombi;
	}

	public int getStraightHighCardValue() {
		return straightHighCardValue;
	}

	public void setStraightHighCardValue(int straightHighCardValue) {
		this.straightHighCardValue = straightHighCardValue;
	}
	

	public String getMessage(){
		return "Straight : " + straightHighCardValue ;
	}
	
}
