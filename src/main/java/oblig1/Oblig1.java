package oblig1;

import java.util.List;

/**
 * Class containing task description and is used for testing the various tasks.
 * 
 * @author Ruben
 */
public final class Oblig1 {

	/*
	 * ### OBLIG 1 TASKS The tasks are implemented in the CardCollectionUtility
	 * class
	 * 
	 * a) Lag en klasse Deck som oppretter en fullstendig kort-stokk (52 kort) b)
	 * Lag en metode «assign» i Deck som plukker tilfeldig n kort fra kortstokket og
	 * returnerer disse i en Collection. «n» er et tall mellom 1 og 52 som sendes
	 * inn som parameter til assign funksjonen. c) Skriv et uttrykk med filter og
	 * forEach som skriver ut alle spar-kort (suit = 'S'). d) Skriv et uttrykk med
	 * filter og collect som samler alle hjerter-kort (suit = 'H') i en ny liste. e)
	 * Skriv et uttrykk med map som gir en ny list med kortenes kortfarge. f) Skriv
	 * et uttrykk med reduce som gir summen av kortverdiene (face). g) Skriv et
	 * uttrykk med anyMatch som sier om spar dame finnes i lista. h) Skriv et
	 * uttrykk som sier om lista er en poker-flush, dvs. har fem kort hvor alle har
	 * samme kortfarge.
	 */

	public static void main(String[] args) {
		// Task a
		Deck deck = new Deck();

		// Task b
		List<Card> randomCardsList = deck.assign(5);
		System.out.println("Task b: " + CardCollectionUtility.getJoinedString(randomCardsList));

		// Task c
		System.out.println("Task c: ");
		CardCollectionUtility.printSpareCards(randomCardsList);

		// Task d
		System.out.println("Task d: "
				+ CardCollectionUtility.getJoinedString(CardCollectionUtility.getHeartCards(randomCardsList)));

		// Task e
		System.out.println("Task e: ");
		CardCollectionUtility.getCardSuits(randomCardsList).forEach(System.out::println);

		// Task f
		System.out.println("Task f: " + CardCollectionUtility.getCardFaceValueSum(randomCardsList));

		// Task g
		System.out.println("Task g: " + CardCollectionUtility.doesQueenOfSpadesExist(randomCardsList));

		// Task h
		System.out.println("Task h: " + CardCollectionUtility.isPokerFlush(randomCardsList));
	}

}
