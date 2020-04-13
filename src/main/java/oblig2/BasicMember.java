package oblig2;

import java.time.LocalDate;

/**
 * This is the type of BonusMember that every new member starts as. A Basic
 * Member has the default advantages, but does not get any kind of extra
 * bonuses.
 * 
 * @author Ruben Christoffer
 */
public class BasicMember extends BonusMember {

	/**
	 * Initializes a new BasicMember instance.
	 * 
	 * @param memberNo     is the membership number
	 * @param personals    contains data about a member
	 * @param enrolledDate is the enrollment date of the member
	 */
	public BasicMember(int memberNo, Personals personals, LocalDate enrolledDate) {
		super(memberNo, personals, enrolledDate);
	}

}
