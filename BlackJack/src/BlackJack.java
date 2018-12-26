public class BlackJack {
	private int numPlayers;
	private Deck deck;
	private Player[] players;
	
	BlackJack(int np) {
		deck = new Deck(true); // create the shuffled deck
		players = new Player[np];	//create all the players
		for(int i = 0; i < np; i++) { 
			players[i] = new Player(); 
		}
		deal();
	}
	
	private void deal() {
		for(int s = 0; s < 2; s++) {
			for(int i = 0; i < players.length; i ++) {
				players[i].addCard(deck.pop());
			}
		}
 	}
	
	public String toString() {
		String result = "";
		for(Player p : players) {
			result += p.toString() + "\n\n";
		}
		return result;
	}

}
