package com.danstoncube.Poker.enums;



public enum CardEnum
{
	
	/* SPADES */
	
	TWO_SPADES(2,"2", CardColorEnum.SPADES),
	THREE_SPADES(3,"3", CardColorEnum.SPADES),
	FOUR_SPADES(4,"4", CardColorEnum.SPADES),
	FIVE_SPADES(5,"5", CardColorEnum.SPADES),
	SIX_SPADES(6,"6", CardColorEnum.SPADES),
	SEVEN_SPADES(7,"7", CardColorEnum.SPADES),
	EIGHT_SPADES(8,"8", CardColorEnum.SPADES),
	NINE_SPADES(9,"9", CardColorEnum.SPADES),
	TEN_SPADES(10,"10", CardColorEnum.SPADES),
	JACK_SPADES(11,"J", CardColorEnum.SPADES),
	QUEEN_SPADES(12,"Q", CardColorEnum.SPADES),
	KING_SPADES(13,"K", CardColorEnum.SPADES),
	AS_SPADES(14,"A", CardColorEnum.SPADES),
	
	/* CLUBS */
	
	TWO_CLUBS(2,"2", CardColorEnum.CLUBS),
	THREE_CLUBS(3,"3", CardColorEnum.CLUBS),
	FOUR_CLUBS(4,"4", CardColorEnum.CLUBS),
	FIVE_CLUBS(5,"5", CardColorEnum.CLUBS),
	SIX_CLUBS(6,"6", CardColorEnum.CLUBS),
	SEVEN_CLUBS(7,"7", CardColorEnum.CLUBS),
	EIGHT_CLUBS(8,"8", CardColorEnum.CLUBS),
	NINE_CLUBS(9,"9", CardColorEnum.CLUBS),
	TEN_CLUBS(10,"10", CardColorEnum.CLUBS),
	JACK_CLUBS(11,"J", CardColorEnum.CLUBS),
	QUEEN_CLUBS(12,"Q", CardColorEnum.CLUBS),
	KING_CLUBS(13,"K", CardColorEnum.CLUBS),
	AS_CLUBS(14,"A", CardColorEnum.CLUBS),
	
	/* DIAMONDS */
	
	TWO_DIAMONDS(2,"2", CardColorEnum.DIAMONDS),
	THREE_DIAMONDS(3,"3", CardColorEnum.DIAMONDS),
	FOUR_DIAMONDS(4,"4", CardColorEnum.DIAMONDS),
	FIVE_DIAMONDS(5,"5", CardColorEnum.DIAMONDS),
	SIX_DIAMONDS(6,"6", CardColorEnum.DIAMONDS),
	SEVEN_DIAMONDS(7,"7", CardColorEnum.DIAMONDS),
	EIGHT_DIAMONDS(8,"8", CardColorEnum.DIAMONDS),
	NINE_DIAMONDS(9,"9", CardColorEnum.DIAMONDS),
	TEN_DIAMONDS(10,"10", CardColorEnum.DIAMONDS),
	JACK_DIAMONDS(11,"J", CardColorEnum.DIAMONDS),
	QUEEN_DIAMONDS(12,"Q", CardColorEnum.DIAMONDS),
	KING_DIAMONDS(13,"K", CardColorEnum.DIAMONDS),
	AS_DIAMONDS(14,"A", CardColorEnum.DIAMONDS),
	
	/* HEARTS */
	
	TWO_HEARTS(2,"2", CardColorEnum.HEARTS),
	THREE_HEARTS(3,"3", CardColorEnum.HEARTS),
	FOUR_HEARTS(4,"4", CardColorEnum.HEARTS),
	FIVE_HEARTS(5,"5", CardColorEnum.HEARTS),
	SIX_HEARTS(6,"6", CardColorEnum.HEARTS),
	SEVEN_HEARTS(7,"7", CardColorEnum.HEARTS),
	EIGHT_HEARTS(8,"8", CardColorEnum.HEARTS),
	NINE_HEARTS(9,"9", CardColorEnum.HEARTS),
	TEN_HEARTS(10,"10", CardColorEnum.HEARTS),
	JACK_HEARTS(11,"J", CardColorEnum.HEARTS),
	QUEEN_HEARTS(12,"Q", CardColorEnum.HEARTS),
	KING_HEARTS(13,"K", CardColorEnum.HEARTS),
	AS_HEARTS(14,"A", CardColorEnum.HEARTS);
	
	
	public int value = 2;
	public String display = "2";
	public CardColorEnum color = CardColorEnum.CLUBS;
	
	CardEnum(int value, String display, CardColorEnum color)
	{
		this.value = value;
		this.display = display;
		this.color = color;
	}
	
	
	public boolean greaterThan(CardEnum anotherCard)
	{
		return value > anotherCard.value;
	}
	
	public boolean lowerThan(CardEnum anotherCard)
	{
		return value < anotherCard.value;
	}
	
}


