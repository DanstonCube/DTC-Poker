package com.danstoncube.poker.game.combination;

import java.util.List;

import com.danstoncube.poker.enums.CardEnum;
import com.danstoncube.poker.enums.CombinationTypeEnum;

public class ThreeOfAKindCombination extends CardCombination {
	private int valueTreeOfAKind;
	private int card1;
	private int card2;
	
	
	public ThreeOfAKindCombination(int pValueTreeOfAKind){
		super();
		valueTreeOfAKind = pValueTreeOfAKind;
		setTypeCombination(CombinationTypeEnum.THREEOFAKIND);
	}
	
	public int compareTo(CardCombination o)	{
		if(this.getTypeCombination().equals(o.getTypeCombination())){
			ThreeOfAKindCombination anotherPair = (ThreeOfAKindCombination)o;
			if(valueTreeOfAKind > anotherPair.getValueTreeOfAKind())
				return 1;
			if(valueTreeOfAKind < anotherPair.getValueTreeOfAKind())
				return -1;
			if(card1 > anotherPair.getCard1())
				return 1;
			if(card1 < anotherPair.getCard1())
				return -1;
			if(card2 > anotherPair.getCard2())
				return 1;
			if(card2 < anotherPair.getCard2())
				return -1;
			return 0;
		}
		return this.getTypeCombination().compareTo(o.getTypeCombination());
	}
	
	public boolean isComplet()
	{
		return card1!= 0 && card2 != 0 && valueTreeOfAKind != 0;
	}
	
	public void addCardValue(int pValue){
		if(card1==0)
			card1 = pValue;
		else if(card2==0)
			card2 = pValue;		
	}

	public int getCard1() {
		return card1;
	}

	public void setCard1(int card1) {
		this.card1 = card1;
	}

	public int getCard2() {
		return card2;
	}

	public void setCard2(int card2) {
		this.card2 = card2;
	}

	public int getValueTreeOfAKind() {
		return valueTreeOfAKind;
	}

	public void setValueTreeOfAKind(int valueTreeOfAKind) {
		this.valueTreeOfAKind = valueTreeOfAKind;
	}	
	
	public String getMessage(){
		return "TreeOfAKind : " + valueTreeOfAKind + " " +  valueTreeOfAKind + " "+  valueTreeOfAKind + " "+  card1 + " "+  card2;
	}
	
	public static ThreeOfAKindCombination getThreeOfAKindCombination(List<CardEnum> pListCards){
		ThreeOfAKindCombination aCombi = null;
		int sameCardCount = 0;
		CardEnum firstCard = pListCards.get(0);
		CardEnum secondCard = null;
		
		for(int i = 1 ; i < pListCards.size();i++){
			secondCard = pListCards.get(i);
			if(firstCard.getValue() == secondCard.getValue()){
				sameCardCount++;
				if(sameCardCount == 2){
					break;
				}				
			}else{
				sameCardCount = 0;
			}
			firstCard = secondCard;
		}
		if(sameCardCount == 2){
			// on stop avant
			aCombi = new ThreeOfAKindCombination(firstCard.getValue());
			for(int i = 0 ; i < pListCards.size() && !aCombi.isComplet();i++){
				CardEnum aCard = pListCards.get(i);				
				if(aCard.getValue() != aCombi.getValueTreeOfAKind()){
					aCombi.addCardValue(aCard.getValue());
				}	
			}
		}
		return aCombi;
	}
}
