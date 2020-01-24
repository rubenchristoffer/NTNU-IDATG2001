package oblig1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Deck {

	private ArrayList<Card> cards;
	
	public Deck () {
		this.cards = new ArrayList<Card>(52);
		
		for (int face = 1; face <= 13; face++) {
			this.cards.add(new Card('S', face));
			this.cards.add(new Card('H', face));
			this.cards.add(new Card('D', face));
			this.cards.add(new Card('C', face));
		}
	}
	
	public List<Card> getCards () {
		return Collections.unmodifiableList(cards);
	}
	
	public List<Card> assign (int n) {
		// Argument validation
		if (n < 1 || n > 52)
			throw new IllegalArgumentException("n has to be between 1 and 52");
		
		ArrayList<Card> returnList = new ArrayList<Card>(cards);
		Collections.shuffle(returnList);
		
		return returnList.stream().filter(card -> returnList.indexOf(card) < n).collect(Collectors.toList());
	}
	
}
