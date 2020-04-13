package oblig1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The deck class is a collection of the 52 cards found in a standard deck.
 * 
 * @author Ruben
 */
public class Deck {

	private ArrayList<Card> cards;

	/**
	 * Initializes a new Deck with 52 cards in order where face is sorted before
	 * suit.
	 */
	public Deck() {
		this.cards = new ArrayList<Card>(52);

		for (int face = 1; face <= 13; face++) {
			this.cards.add(new Card('S', face));
			this.cards.add(new Card('H', face));
			this.cards.add(new Card('D', face));
			this.cards.add(new Card('C', face));
		}
	}

	/**
	 * Gets all the cards in the deck.
	 * 
	 * @return a read-only wrapper list of all the cards in the deck
	 */
	public List<Card> getCards() {
		return Collections.unmodifiableList(cards);
	}

	/**
	 * Gets n random cards from the deck.
	 * 
	 * @param n is the amount of random cards you want
	 * @return a list containing n random cards
	 * @throws IllegalArgumentException if n is not between 1 and 52
	 */
	public List<Card> assign(int n) {
		// Argument validation
		if (n < 1 || n > 52)
			throw new IllegalArgumentException("n has to be between 1 and 52");

		ArrayList<Card> returnList = new ArrayList<Card>(cards);
		Collections.shuffle(returnList);

		return returnList.stream().filter(card -> returnList.indexOf(card) < n).collect(Collectors.toList());
	}

}
