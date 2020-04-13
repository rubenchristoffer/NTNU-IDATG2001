package oblig2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Base class for all kinds of Members in the Bonus program.
 * 
 * @author Ruben Christoffer
 */
public abstract class BonusMember {

	/**
	 * Base points are multiplied by this factor if the member in question is a
	 * silver member.
	 */
	public static final float FACTOR_SILVER = 1.2f;

	/**
	 * Base points are multiplied by this factor if the member in question is a gold
	 * member.
	 */
	public static final float FACTOR_GOLD = 1.5f;

	private final int memberNo;
	private final Personals personals;
	private final LocalDate enrolledDate;

	private int bonusPoints = 0;

	/**
	 * Initializes a new BonusMember instance.
	 * 
	 * @param memberNo     is the membership number
	 * @param personals    contains data about a member
	 * @param enrolledDate is the enrollment date of the member
	 * @param bonusPoints  is the amount of bonus points the member has
	 * @throws IllegalArgumentException if ints are less than 0 or if objects are
	 *                                  null
	 */
	protected BonusMember(int memberNo, Personals personals, LocalDate enrolledDate, int bonusPoints) {
		if (memberNo < 0)
			throw new IllegalArgumentException("memberNo cannot be a negative number");
		if (personals == null)
			throw new IllegalArgumentException("personals cannot be null");
		if (enrolledDate == null)
			throw new IllegalArgumentException("enrolledDate cannot be null");
		if (bonusPoints < 0)
			throw new IllegalArgumentException("bonusPoints cannot be a negative number");

		this.memberNo = memberNo;
		this.personals = personals;
		this.enrolledDate = enrolledDate;
		this.bonusPoints = bonusPoints;
	}

	/**
	 * Initializes a new BonusMember instance where bonusPoints is set to 0.
	 * 
	 * @param memberNo     is the membership number
	 * @param personals    contains data about a member
	 * @param enrolledDate is the enrollment date of the member
	 * @see #BonusMember(int, Personals, LocalDate, int)
	 */
	protected BonusMember(int memberNo, Personals personals, LocalDate enrolledDate) {
		this(memberNo, personals, enrolledDate, 0);
	}

	/**
	 * Gets the membership number.
	 * 
	 * @return integer number
	 */
	public int getMemberNo() {
		return memberNo;
	}

	/**
	 * Gets the data regarding this member.
	 * 
	 * @return Personals object
	 */
	public Personals getPersonals() {
		return personals;
	}

	/**
	 * Gets the date of enrollment.
	 * 
	 * @return LocalDate object
	 */
	public LocalDate getEnrolledDate() {
		return enrolledDate;
	}

	/**
	 * Gets the current amount of bonus points.
	 * 
	 * @return integer number
	 */
	public int getBonuspoints() {
		return bonusPoints;
	}

	/**
	 * Finds the amount of points that can be used for qualifying to a higher
	 * membership type.
	 * 
	 * @param localDate is the current date.
	 * @return current bonus points if amount of days between enrollment date and
	 *         localDate is less than or equal to 365, otherwise 0.
	 */
	public int findQualificationPoints(LocalDate localDate) {
		long daysBetween = ChronoUnit.DAYS.between(getEnrolledDate(), localDate);

		return daysBetween <= 365 ? getBonuspoints() : 0;
	}

	/**
	 * Same as {@link Personals#okPassword(String)}. NOTE: This is not safe to use
	 * in any kind of real system as passwords are stored in clear-text!
	 * 
	 * @param password is the password in clear-text
	 * @return true if passwords match
	 */
	public boolean okPassword(String password) {
		return getPersonals().okPassword(password);
	}

	/**
	 * Registers points to this member based on base points that should be awarded.
	 * 
	 * @param basePoints is the amount of points that should be awarded before any
	 *                   kind of extra bonuses are accounted for
	 * @throws IllegalArgumentException if basePoints are less than or equal to 0
	 *                                  because you can never subtract points
	 */
	public void registerPoints(int basePoints) {
		if (basePoints <= 0)
			throw new IllegalArgumentException("basePoints has to be over 0");

		this.bonusPoints += basePoints;
	}

}
