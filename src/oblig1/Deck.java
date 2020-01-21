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
	
	public List<Card> assign (int n) {
		// Argument validation
		if (n < 1 || n > 52)
			throw new IllegalArgumentException("n has to be between 1 and 52");
		
		ArrayList<Card> returnList = new ArrayList<Card>(cards);
		Collections.shuffle(returnList);
		
		return returnList.stream().filter(card -> returnList.indexOf(card) < n).collect(Collectors.toList());
	}
	
	public void printSpareCards () {
		cards.stream().filter(card -> card.getSuit() == 'S').forEach(System.out::println);
	}
	
	public List<Card> collectHeartCards () {
		return cards.stream().filter(card -> card.getSuit() == 'H').collect(Collectors.toList());
	}
	
	public List<Character> getCardSuits () {
		return cards.stream().map(card -> card.getSuit()).collect(Collectors.toList());
	}
	
	public int getCardFaceValueSum () {
		return cards.stream().reduce(0, (sum, card) -> sum + card.getFace(), (int1, int2) -> int1 + int2);
	}
	
	public boolean doesQueenOfSpadesExist () {
		return cards.stream().anyMatch(card -> card.getFace() == 12 && card.getSuit() == 'S');
	}
	
	public boolean hasPokerFlush () {
		long nrSpades = cards.stream().filter(card -> card.getSuit() == 'S').count();

		if (nrSpades >= 5) 
			return true;
		
		long nrHearts = cards.stream().filter(card -> card.getSuit() == 'H').count();
		
		if (nrHearts >= 5) 
			return true;
		
		long nrDiamonds = cards.stream().filter(card -> card.getSuit() == 'D').count();
		
		if (nrDiamonds >= 5)
			return true;
		
		long nrClubs = cards.stream().filter(card -> card.getSuit() == 'C').count();
		
		return nrClubs >= 5;
	}
	
}
