package com.danstoncube.Poker;


public enum Card
{
	AS_SPADES(14,"A", CardColor.SPADES);
	//AS_SPADE(14,"A");
	//AS_SPADE(14,"A");
	
	
	public int value = 2;
	public String display = "2";
	public CardColor color = CardColor.CLUBS;
	
	Card(int value, String display, CardColor color)
	{
		this.value = value;
		this.display = display;
		this.color = color;
	}
	
	
	public boolean greaterThan(Card anotherCard)
	{
		return value > anotherCard.value;
	}
	
	public boolean lowerThan(Card anotherCard)
	{
		return value < anotherCard.value;
	}
	
}


