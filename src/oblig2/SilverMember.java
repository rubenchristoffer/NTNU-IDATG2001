package oblig2;

import java.time.LocalDate;

/**
 * A Silver Member is a Bonus Member with the next highest
 * amount of privileges where their base points
 * are multiplied by {@link BonusMember#FACTOR_SILVER}.
 * @author Ruben Christoffer
 */
public class SilverMember extends BonusMember {

	/**
	 * Initializes a new SilverMember instance.
	 * @param memberNo is the membership number
	 * @param personals contains data about a member
	 * @param enrolledDate is the enrollment date of the member
	 * @param bonusPoints is the amount of bonus points that this member has previously.
	 */
	public SilverMember(int memberNo, Personals personals, LocalDate enrolledDate, int bonusPoints) {
		super(memberNo, personals, enrolledDate, bonusPoints);
	}
	
	@Override
	public void registerPoints(int bonusPoints) {
		super.registerPoints((int)(bonusPoints * BonusMember.FACTOR_SILVER));
	}
	
}
