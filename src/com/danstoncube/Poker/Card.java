package com.danstoncube.Poker;


public enum Card
{
	
	/* SPADES */
	
	TWO_SPADES(2,"2", CardColor.SPADES),
	THREE_SPADES(3,"3", CardColor.SPADES),
	FOUR_SPADES(4,"4", CardColor.SPADES),
	FIVE_SPADES(5,"5", CardColor.SPADES),
	SIX_SPADES(6,"6", CardColor.SPADES),
	SEVEN_SPADES(7,"7", CardColor.SPADES),
	EIGHT_SPADES(8,"8", CardColor.SPADES),
	NINE_SPADES(9,"9", CardColor.SPADES),
	TEN_SPADES(10,"10", CardColor.SPADES),
	JACK_SPADES(11,"J", CardColor.SPADES),
	QUEEN_SPADES(12,"Q", CardColor.SPADES),
	KING_SPADES(13,"K", CardColor.SPADES),
	AS_SPADES(14,"A", CardColor.SPADES),
	
	/* CLUBS */
	
	TWO_CLUBS(2,"2", CardColor.CLUBS),
	THREE_CLUBS(3,"3", CardColor.CLUBS),
	FOUR_CLUBS(4,"4", CardColor.CLUBS),
	FIVE_CLUBS(5,"5", CardColor.CLUBS),
	SIX_CLUBS(6,"6", CardColor.CLUBS),
	SEVEN_CLUBS(7,"7", CardColor.CLUBS),
	EIGHT_CLUBS(8,"8", CardColor.CLUBS),
	NINE_CLUBS(9,"9", CardColor.CLUBS),
	TEN_CLUBS(10,"10", CardColor.CLUBS),
	JACK_CLUBS(11,"J", CardColor.CLUBS),
	QUEEN_CLUBS(12,"Q", CardColor.CLUBS),
	KING_CLUBS(13,"K", CardColor.CLUBS),
	AS_CLUBS(14,"A", CardColor.CLUBS),
	
	/* DIAMONDS */
	
	TWO_DIAMONDS(2,"2", CardColor.DIAMONDS),
	THREE_DIAMONDS(3,"3", CardColor.DIAMONDS),
	FOUR_DIAMONDS(4,"4", CardColor.DIAMONDS),
	FIVE_DIAMONDS(5,"5", CardColor.DIAMONDS),
	SIX_DIAMONDS(6,"6", CardColor.DIAMONDS),
	SEVEN_DIAMONDS(7,"7", CardColor.DIAMONDS),
	EIGHT_DIAMONDS(8,"8", CardColor.DIAMONDS),
	NINE_DIAMONDS(9,"9", CardColor.DIAMONDS),
	TEN_DIAMONDS(10,"10", CardColor.DIAMONDS),
	JACK_DIAMONDS(11,"J", CardColor.DIAMONDS),
	QUEEN_DIAMONDS(12,"Q", CardColor.DIAMONDS),
	KING_DIAMONDS(13,"K", CardColor.DIAMONDS),
	AS_DIAMONDS(14,"A", CardColor.DIAMONDS),
	
	/* HEARTS */
	
	TWO_HEARTS(2,"2", CardColor.HEARTS),
	THREE_HEARTS(3,"3", CardColor.HEARTS),
	FOUR_HEARTS(4,"4", CardColor.HEARTS),
	FIVE_HEARTS(5,"5", CardColor.HEARTS),
	SIX_HEARTS(6,"6", CardColor.HEARTS),
	SEVEN_HEARTS(7,"7", CardColor.HEARTS),
	EIGHT_HEARTS(8,"8", CardColor.HEARTS),
	NINE_HEARTS(9,"9", CardColor.HEARTS),
	TEN_HEARTS(10,"10", CardColor.HEARTS),
	JACK_HEARTS(11,"J", CardColor.HEARTS),
	QUEEN_HEARTS(12,"Q", CardColor.HEARTS),
	KING_HEARTS(13,"K", CardColor.HEARTS),
	AS_HEARTS(14,"A", CardColor.HEARTS);
	
	
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


