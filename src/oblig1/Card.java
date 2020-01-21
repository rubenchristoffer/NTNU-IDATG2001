package oblig1;

/**
 * Represents a playing card. A playing card has a number (face) between
 * 1 and 13, where 1 is called an Ace, 11 = Knight, 12 = Queen and 13 = King.
 * The card can also be one of 4 suits: Spade, Heart, Diamonds and Clubs.
 *
 * @author ntnu
 * @version 2020-01-10
 */
public class Card {

	private final char suit; // 'S'=spade, 'H'=heart, 'D'=diamonds, 'C'=clubs
	private final int face; // a number between 1 and 13

	/**
	 * Creates an instance of a Card with a given suit and face.
	 *
	 * @param suit The suit of the card, as a single character. 'S' for Spades,
	 *             'H' for Heart, 'D' for Diamonds and 'C' for clubs
	 * @param face The face value of the card, an integer between 1 and 13
	 */
	public Card(char suit, int face) {
		this.suit = suit;
		this.face = face;
	}

	/**
	 * Returns the suit and face of the card as a string.
	 * A 4 of hearts is returned as the string "H4".
	 *
	 * @return the suit and face of the card as a string
	 */
	public String getDetails() {
		return String.format("%s%s", suit, face);
	}

	/**
	 * Returns the suit of the card, 'S' for Spades, 'H' for Heart, 'D' for Diamonds and 'C' for clubs
	 *
	 * @return the suit of the card
	 */
	public char getSuit() {
		return suit;
	}

	/**
	 * Returns the face of the card (value between 1 and 13).
	 *
	 * @return the face of the card
	 */
	public int getFace() {
		return face;
	}
}


/*a) Lag en klasse Deck som oppretter en fullstendig kort-stokk (52 kort)
b) Lag en metode «assign» i Deck som plukker tilfeldig n kort fra kortstokket og returnerer disse
i en Collection. «n» er et tall mellom 1 og 52 som sendes inn som parameter til assign
funksjonen.
c) Skriv et uttrykk med filter og forEach som skriver ut alle spar-kort (suit = 'S').
d) Skriv et uttrykk med filter og collect som samler alle hjerter-kort (suit = 'H') i en ny liste.
e) Skriv et uttrykk med map som gir en ny list med kortenes kortfarge.
f) Skriv et uttrykk med reduce som gir summen av kortverdiene (face).
g) Skriv et uttrykk med anyMatch som sier om spar dame finnes i lista.
h) Skriv et uttrykk som sier om lista er en poker-flush, dvs. har fem kort hvor alle har samme
kortfarge.*/