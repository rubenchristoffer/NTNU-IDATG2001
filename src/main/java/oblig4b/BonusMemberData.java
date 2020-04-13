package oblig4b;

import java.time.LocalDate;

import oblig2.Personals;

/**
 * This is a data class that is later used for creating a BonusMember.
 * 
 * @author Ruben Christoffer
 */
public class BonusMemberData {

	private Personals personals;
	private LocalDate localDate;

	/**
	 * Constructs a new BonusMemberData object.
	 * 
	 * @param personals is the personal data connected to the member
	 * @param localDate is the enrollment date of the member
	 */
	public BonusMemberData(Personals personals, LocalDate localDate) {
		this.personals = personals;
		this.localDate = localDate;
	}

	/**
	 * Gets the personal data connected to member.
	 * 
	 * @return Personals object
	 */
	public Personals getPersonals() {
		return personals;
	}

	/**
	 * Gets the enrollment date of the member.
	 * 
	 * @return LocalDate object
	 */
	public LocalDate getLocalDate() {
		return localDate;
	}

}
