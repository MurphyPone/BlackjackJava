import java.util.ArrayList;

public class Player {
	private ArrayList<Card> cards;
	private boolean busted;
	private boolean blackjack;
	
	Player() {
		cards = new ArrayList<Card>();
		busted = false;
	}
	
	//Helpers
	private int sum() {
		int result = 0;
		for(int i = 0; i < cards.size(); i ++) {
			result += cards.get(i).getValue();
		}
		return result;
		
	}
	
	/*
	 * 0 = not busted
	 * 1 = busted
	 * 2 = 21;
	 */
	private int check() {
		int sum = sum();
		if(sum < 21) {
			busted = false;
			return 0;
		} else if (sum == 21) {
			busted = false;
			blackjack = true;
			return 2;
		} else {
			busted = true;
			return 1;
		}
	}
	
	//Returns the sum of the hand after adding the top card from the deck
	int addCard(Card c) {
		cards.add( c );
		return sum();
	}
	
	public String toString() {
		String result = "";
		for(Card c : cards) {
			result += c + "\n";
		}
		return result + sum();
	}
}
