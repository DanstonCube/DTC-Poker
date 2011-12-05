package com.danstoncube.poker.game.combination;

import java.util.List;

import com.danstoncube.poker.enums.CardEnum;
import com.danstoncube.poker.enums.CombinationTypeEnum;

public class QuadCombination extends CardCombination {

	private int quadValue = 0;
	private int hightCardValue = 0;
	
	public QuadCombination(int pValueQuad){
		super();
		quadValue = pValueQuad;
		setTypeCombination(CombinationTypeEnum.QUAD);
	}
	
	@Override
	public boolean isComplet() {
		return quadValue!=0 && hightCardValue != 0;
	}

	public int compareTo(CardCombination o) {
		if(this.getTypeCombination().equals(o.getTypeCombination())){
			QuadCombination anotherCombi = (QuadCombination)o;
			if(quadValue > anotherCombi.getQuadValue())
				return 1;
			if(quadValue < anotherCombi.getQuadValue())
				return -1;
			if(hightCardValue > anotherCombi.getHightCardValue())
				return 1;
			if(hightCardValue < anotherCombi.getHightCardValue())
				return -1;
			return 0;
		}
		return this.getTypeCombination().compareTo(o.getTypeCombination());
	}

	public int getHightCardValue() {
		return hightCardValue;
	}

	public void setHightCardValue(int hightCardValue) {
		this.hightCardValue = hightCardValue;
	}

	public int getQuadValue() {
		return quadValue;
	}

	public void setQuadValue(int quadValue) {
		this.quadValue = quadValue;
	}
	
	public String getMessage(){
		return "Quad : " + quadValue + " " +  quadValue + " "+  quadValue + " "+  quadValue + " "+  hightCardValue;
	}
	
	public static QuadCombination getQuadCombination(List<CardEnum> pListCards){
		QuadCombination aCombi = null;
		if(pListCards.get(0).getValue() == pListCards.get(3).getValue()){
			aCombi = new QuadCombination(pListCards.get(0).getValue());
			aCombi.setHightCardValue(pListCards.get(4).getValue());
		}
		else if(
			   pListCards.get(1).getValue() == pListCards.get(4).getValue()
			|| pListCards.get(2).getValue() == pListCards.get(5).getValue()
			|| pListCards.get(3).getValue() == pListCards.get(6).getValue()
				)
		{	
			aCombi = new QuadCombination(pListCards.get(4).getValue());
			aCombi.setHightCardValue(pListCards.get(0).getValue());			
		}
		return aCombi;
	}

}
