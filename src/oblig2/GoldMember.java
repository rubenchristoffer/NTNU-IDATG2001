package oblig2;

import java.time.LocalDate;

public class GoldMember extends BonusMember {

	public GoldMember(int memberNo, Personals personals, LocalDate enrolledDate, int bonusPoints) {
		super(memberNo, personals, enrolledDate, bonusPoints);
	}

	@Override
	public void registerPoints(int bonusPoints) {
		super.registerPoints((int)(bonusPoints * BonusMember.FACTOR_GOLD));
	}

}
