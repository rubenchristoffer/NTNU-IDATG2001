package oblig2;

import java.time.LocalDate;

/**
 * A Gold Member is a Bonus Member with the highest
 * amount of privileges where their base points
 * are multiplied by {@link BonusMember#FACTOR_GOLD}.
 * @author Ruben Christoffer
 */
public class GoldMember extends BonusMember {

	/**
	 * Initializes a new GoldMember instance.
	 * @param memberNo is the membership number
	 * @param personals contains data about a member
	 * @param enrolledDate is the enrollment date of the member
	 * @param bonusPoints is the amount of bonus points that this member has previously.
	 */
	public GoldMember(int memberNo, Personals personals, LocalDate enrolledDate, int bonusPoints) {
		super(memberNo, personals, enrolledDate, bonusPoints);
	}

	@Override
	public void registerPoints(int basePoints) {
		super.registerPoints((int)(basePoints * BonusMember.FACTOR_GOLD));
	}

}
