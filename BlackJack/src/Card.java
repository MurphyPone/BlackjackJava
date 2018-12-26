public class Card {
	public static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
	public static final String[] RANKS = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
	public static final int[] VALUES	= {1	, 2,		3,		4,		5,		6,		7,		8,		9,		10,		10,		10,		10	};
	
	private String rank;
	private String suit;
	private int value;
	
	/*
	 * Default constructor
	 */
	Card(String suit, int value) { 
		this.suit = suit;
		this.rank = RANKS[value];
		this.value = VALUES[value];
	} 
	
	/*
	 * Random Card constructor
	 */
	Card() {
		int suit_index = (int) Math.floor(Math.random() * SUITS.length);
		int value_index = (int) Math.floor(Math.random() * VALUES.length);
		this.suit = SUITS[suit_index];
		this.rank = RANKS[value_index];
		this.value = value_index;
	}
	
	//Helpers//
	
	//getter 
	String getSuit() {
		return this.suit;
	}
	
	String getRank() {
		return this.rank;
	}
	
	int getValue() {
		return this.value;
	}
	
	//Setters
	void setSuit(String suit) {
		this.suit = suit;
	}
	
	void setRank(String rank) {
		this.suit = rank;
	}
	
	void setValue(int value) {
		this.value = value;
	}
	
	//Additional
	
	public String toString() {
		return this.rank + " of " + this.suit;
	}
	
	boolean equals(Card c) {
		return this.rank.equals(c.getRank()) &&
				this.suit.equals(c.getSuit()) &&
				this.value == c.getValue();
	}
}
