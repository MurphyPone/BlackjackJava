import java.util.Scanner;

public class BlackJack {
	private int numPlayers;
	private Deck deck;
	private Player[] players;
	private Player house;
	Scanner kb;
	
	BlackJack(int np) {
		kb = new Scanner( System.in );
		deck = new Deck(true); // create the shuffled deck
		players = new Player[np];	//create all the players
		for(int i = 0; i < np; i++) { 
			players[i] = new Player(); 
		}
		house = new Player();
		deal();
	}
	
	void play() {
		//while(deck.peek() != null) {
			for(int i = 0; i < players.length; i++) {
				while( players[i].check() && players[i].getPlaying() && house.check() ) {
					System.out.println("House: \n" + house.getCards().get(0) + "\n" + house.getCards().get(0).getValue() + "\n");
					System.out.println("Player[" + i + "]: \n" + players[i] + "\n" + "\nHit (h)/ Stand (s):");
					String response = kb.next();
					if( response.equals("h") ) {
						System.out.println(deck.peek());
						players[i].addCard(deck.pop());
					} else if( response.equals("s") ) {
						players[i].setPlaying(false);
					}
				}	
			}
			//All players have gone through hitting
			doHouse();
			results();
		//}
		System.out.println("the Deck needs to be Shuffled");
	}
	
	void doHouse() {
		System.out.print("\nHOUSE PLAYING\n");
		while(house.sum() < 17) {
			System.out.println("House: \n" + house + "\n");
			System.out.println( deck.peek() );
			house.addCard( deck.pop() );
		}
		
		if(house.sum() > 21) {
			//payAll
			System.out.println("All remaining players win");
		} else {
			System.out.println("House: \n" + house + "\n");
		}
	}
	
	void results() {
		System.out.println("---RESULTS---\n");
		//Compare all players
		for(int i = 0; i < players.length; i++) {
			System.out.println("Player[" + i + "]: " + players[i].sum() + "\n");
		}
		System.out.println("House: " + house );
		int houseSum = house.sum();
		if (houseSum > 21) {
			System.out.println("The House busted! All Remaining players win.");
		} else {
			for(int i = 0; i < players.length; i++) {
				if(houseSum > players[i].sum() ) {
					System.out.println("Player["+i+"] busted");
				} else if(houseSum < players[i].sum() ) {
					System.out.println("Player["+i+"] wins");
				} else {
					System.out.println("Player["+i+"] pushes");
				}
			}
		}

	}
	
	private void deal() {
		for(int s = 0; s < 2; s++) {
			for(int i = 0; i < players.length; i ++) {
				players[i].addCard(deck.pop());
			}
		}
		house.addCard(deck.pop());
		house.addCard(deck.pop());
		//TODO check if house has 21 right away here?
 	}
	
	public String toString() {
		String result = "";
		for(Player p : players) {
			result += p.toString() + "\n\n";
		}
		return result;
	}

}
