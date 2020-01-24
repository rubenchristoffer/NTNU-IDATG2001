package oblig1;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility class containing useful functions
 * when dealing with collections of cards
 * @author Ruben
 */
public final class CardCollectionUtility {

	/**
	 * Prints all cards of the suit 'Spare'.
	 * @param cardCollection is the collection of cards
	 */
	public static void printSpareCards (Collection<Card> cardCollection) {
		cardCollection.stream()
			.filter(card -> card.getSuit() == 'S')
			.forEach(System.out::println); // Card has a modified toString mapping to Card::getDetails, so this works
	}
	
	/**
	 * Gets a list of only the cards of suit 'Heart'
	 * @param cardCollection is the collection of cards
	 * @return list containing cards where suit is 'Heart'
	 */
	public static List<Card> getHeartCards (Collection<Card> cardCollection) {
		return cardCollection.stream()
			.filter(card -> card.getSuit() == 'H')
			.collect(Collectors.toList());
	}
	
	/**
	 * Gets a list of all the suits of the cards
	 * in correct order.
	 * @param cardCollection is the collection of cards
	 * @return list of chars representing the card suits
	 */
	public static List<Character> getCardSuits (Collection<Card> cardCollection) {
		return cardCollection.stream()
			.map(card -> card.getSuit())
			.collect(Collectors.toList());
	}
	
	/**
	 * Gets the sum of all the face values of cards.
	 * @param cardCollection
	 * @return integer representing sum of all the face values
	 */
	public static int getCardFaceValueSum (Collection<Card> cardCollection) {
		return cardCollection.stream()
			.reduce(0, (sum, card) -> sum + card.getFace(), (int1, int2) -> int1 + int2); // This works for parallel streams too and doesn't require mapping first
	}
	
	/**
	 * Checks if the queen of spades are any of the cards.
	 * @param cardCollection is the collection of cards
	 * @return true if queen of spades is in the card collection
	 */
	public static boolean doesQueenOfSpadesExist (Collection<Card> cardCollection) {
		return cardCollection.stream()
			.anyMatch(card -> card.getFace() == 12 && card.getSuit() == 'S');
	}
	
	/**
	 * This function checks if the card collection 
	 * has at least 5 cards of the same suit
	 * @param cardCollection is the collection of cards
	 * @return true if 5 or more cards contain same suit
	 */
	public static boolean hasPokerFlush (Collection<Card> cardCollection) {
		return cardCollection.stream()
			.collect(Collectors.groupingBy(Card::getSuit, Collectors.counting())) // Group sums of each suit together
			.values().stream().anyMatch(count -> count >= 5); // Return if the count of any suit is greater or equal to 5
	}
	
	/**
	 * This function checks if the cards collection
	 * has a size of at least 5 and only contains
	 * cards of one suit.
	 * @param cardCollection is the collection of cards
	 * @return true if there are 5 or more cards in 
	 * collection and they all have the same suit
	 */
	public static boolean isPokerFlush (Collection<Card> cardCollection) {
		return cardCollection.size() >= 5 && // Check if at least 5 cards in collection
			cardCollection.stream()
				.map(card -> card.getSuit()) // Extract suits of cards
				.distinct() // Extract only distinct suits
				.count() == 1; // Return true if only 1 suit type
	}
	
	/**
	 * Gets a single string where each card is separated by comma.
	 * @param cardCollection is the collection of cards
	 * @return a string where each card is separated by comma
	 */
	public static String getJoinedString (Collection<Card> cardCollection) {
		return cardCollection.stream().map(Card::getDetails).collect(Collectors.joining(", "));
	}
	
}
