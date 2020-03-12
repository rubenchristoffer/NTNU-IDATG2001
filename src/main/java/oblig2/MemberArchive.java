package oblig2;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;

/**
 * MemberArchive is a archive of Bonus Members
 * and contains various methods used to interact
 * with these members.
 * @author Ruben Christoffer
 */
public class MemberArchive {

	/**
	 * This is the minimum required bonus points required
	 * to be upgraded to a silver member.
	 */
	public static final int SILVER_LIMIT = 25000;
	
	/**
	 * This is the minimum required bonus points required
	 * to be upgraded to a gold member.
	 */
	public static final int GOLD_LIMIT = 75000;
	
	private HashMap<Integer, BonusMember> membersMap = new HashMap<Integer, BonusMember>();
	private Random randomGenerator = new Random();
	
	/**
	 * Finds the amount of points of a member given
	 * membership number and password in clear-text.
	 * @param memberNo is the membership number
	 * @param password is the password in clear-text
	 * @return amount of points this member has or -1
	 * if either member does not exist or password
	 * is incorrect
	 */
	public int findPoints (int memberNo, String password) {
		BonusMember member = membersMap.get(memberNo);
		
		// Perform validation
		if (member == null)
			return -1;
		
		if (!member.okPassword(password))
			return -1;
		
		return member.getBonuspoints();
	}
	
	/**
	 * Registers bonus points for a member
	 * based on amount of base points.
	 * @param memberNo is the membership number
	 * @param basePoints is the amount of points
	 * that should be awarded before any kind of
	 * extra bonuses are accounted for
	 * @return true if registering points were
	 * a success, false otherwise (if member does
	 * not exist for instance)
	 */
	public boolean registerPoints (int memberNo, int basePoints) {
		BonusMember member = membersMap.get(memberNo);
		
		// Perform validation
		if (member == null)
			return false;
		
		member.registerPoints(basePoints);
		return true;
	}
	
	/**
	 * Adds a new member to the archive.
	 * @param pers is the data about this member
	 * @param dateEnrolled is the enrollment date
	 * @return the randomly generated membership number
	 * of the new member
	 */
	public int addMember (Personals pers, LocalDate dateEnrolled) {
		BasicMember member = new BasicMember(findAvailableNo(), pers, dateEnrolled);
		membersMap.put(member.getMemberNo(), member);
		
		return member.getMemberNo();
	}
	
	/**
	 * Checks if any members qualify for a upgrade
	 * and upgrades them accordingly.
	 * @param localDate is the current date
	 */
	public void checkMembers (LocalDate localDate) {
		membersMap.values().forEach(m -> membersMap.put(m.getMemberNo(), tryUpgradingMember(m, localDate)));
	}
	
	/**
	 * Gets member based on membership number.
	 * @param memberNo is the membership number
	 * @return BonusMember object
	 */
	public BonusMember getMember (int memberNo) {
		return membersMap.get(memberNo);
	}
	
	/**
	 * Deletes the member from the archive.
	 * @param memberNo is the membership number
	 */
	public void deleteMember (int memberNo) {
		membersMap.remove(memberNo);
	}
	
	/**
	 * Gets a collection of all the members in this archive.
	 * @return collection of BonusMember objects
	 */
	public Collection<BonusMember> getMembers () {
		return membersMap.values();
	}
	
	private int findAvailableNo() {
		return randomGenerator
				.ints(0, 1000000)
				.filter(i -> !membersMap.containsKey(i))
				.findAny()
				.getAsInt();
	}
	
	private BonusMember tryUpgradingMember (BonusMember member, LocalDate localDate) {
		int points = member.findQualificationPoints(localDate);
		
		if (points >= GOLD_LIMIT && !(member instanceof GoldMember))
			return new GoldMember(member.getMemberNo(), member.getPersonals(), member.getEnrolledDate(), member.getBonuspoints());
		if (points >= SILVER_LIMIT && member instanceof BasicMember)
			return new SilverMember(member.getMemberNo(), member.getPersonals(), member.getEnrolledDate(), member.getBonuspoints());
		
		return member;
	}
	
}
