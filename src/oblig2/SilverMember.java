package oblig2;

import java.time.LocalDate;

public class SilverMember extends BonusMember {

	public SilverMember(int bonuspoints, Personals personals, LocalDate enrolledDate) {
		super(bonuspoints, personals, enrolledDate);
	}
	
	@Override
	public void registerPoints(int bonusPoints) {
		super.registerPoints((int)(bonusPoints * BonusMember.FACTOR_SILVER));
	}
	
}
