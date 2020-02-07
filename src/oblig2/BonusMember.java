package oblig2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

/**
 * Base class for all kinds of Members
 * in the Bonus program.
 * @author Ruben Christoffer
 */
public class BonusMember {

	public static final float FACTOR_SILVER = 1.2f;
	public static final float FACTOR_GOLD = 1.5f;
	
	private final int memberNo;
	private final Personals personals;
	private final LocalDate enrolledDate;
	private int bonusPoints = 0;
	
	protected BonusMember(int bonuspoints, Personals personals, LocalDate enrolledDate) {
		this.memberNo = new Random().nextInt(Integer.MAX_VALUE);
		this.personals = personals;
		this.enrolledDate = enrolledDate;
		this.bonusPoints = bonuspoints;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public Personals getPersonals() {
		return personals;
	}

	public LocalDate getEnrolledDate() {
		return enrolledDate;
	}

	public int getBonuspoints() {
		return bonusPoints;
	}
	
	public int findQualificationPoints (LocalDate localDate) {
		long daysBetween = ChronoUnit.DAYS.between(getEnrolledDate(), localDate);
		
		return daysBetween <= 365 ? getBonuspoints() : 0;
	}
	
	/**
	 * This is not safe.
	 * @param password
	 * @return
	 */
	public boolean okPassword (String password) {
		return getPersonals().okPassword(password);
	}
	
	public void registerPoints (int bonusPoints) {
		this.bonusPoints += bonusPoints;
	}

}
