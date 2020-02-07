package oblig2;

import java.time.LocalDate;

public class SilverMember extends BonusMember {

	public SilverMember(int memberNo, Personals personals, LocalDate enrolledDate, int bonusPoints) {
		super(memberNo, personals, enrolledDate, bonusPoints);
	}
	
	@Override
	public void registerPoints(int bonusPoints) {
		super.registerPoints((int)(bonusPoints * BonusMember.FACTOR_SILVER));
	}
	
}
