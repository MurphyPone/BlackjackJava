import java.util.ArrayList;

public class Player {
	private ArrayList<Card> cards;
	private boolean busted;
	private boolean blackjack;
	private boolean playing;
	
	Player() {
		cards = new ArrayList<Card>();
		busted = false;
		playing = true;
	}
	
	
	//Helpers
	public int sum() {
		int result = 0;
		for(int i = 0; i < cards.size(); i ++) {
			result += cards.get(i).getValue();
		}
		return result;
		
	}
	
	public boolean check() {
		if (sum() > 21 && hasAce() ) {
			return (sum() - 10) <= 21;
		} else 
			return sum() <= 21;
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
	
	public boolean getPlaying() {
		return this.playing;
	}
	
	public void setPlaying(boolean x) {
		this.playing = x;
	}
	
	public ArrayList<Card> getCards() {
		return cards;
	}
	
	boolean hasAce() {
		for(Card c : cards) {
			if(c.getValue() == 11)
				return true;
		}
		return false;
	}
}
