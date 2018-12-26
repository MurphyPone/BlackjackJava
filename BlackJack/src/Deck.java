import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Deck {
	private int numCards;
	private Stack<Card> deck;	

	
	/*
	 * Default constructor
	 */
	Deck() {
		numCards = 52;
		Card[] tempDeck = new Card[numCards];
		deck = new Stack<Card>();
		
		//create tempDeck array
		int s = 0;
		while (s < Card.SUITS.length ) {		
			for(int i = 0; i < Card.VALUES.length; i++) {
				String suit = Card.SUITS[s];
				int index = i + (s*13);
				Card theCard = new Card(suit, i);
				
				tempDeck[index] = theCard;
				deck.push(theCard);
			}
			s++;	//Go to next suit
		}		
	}
	
	Deck(boolean shuffled) {
		numCards = 52;
		Card[] tempDeck = new Card[numCards];
		deck = new Stack<Card>();
		
		//create tempDeck array
		int s = 0;
		while (s < Card.SUITS.length ) {		
			for(int i = 0; i < Card.VALUES.length; i++) {
				String suit = Card.SUITS[s];
				int index = i + (s*13);
				Card theCard = new Card(suit, i);
				
				tempDeck[index] = theCard;
				deck.push(theCard);
			}
			s++;	//Go to next suit
		}	
		if (shuffled) { shuffle(); } 
	}

	
	/*
	 * Shuffle
	 */
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	public Card pop() {
		return deck.pop();
	}
	
	public String toString() {
		return deck.toString();
	}
}
