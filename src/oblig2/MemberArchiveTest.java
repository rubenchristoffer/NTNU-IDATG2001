package oblig2;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberArchiveTest {

	private Personals person1;
	private Personals person2;
	private Personals person3;
	
	private LocalDate date1;
	private LocalDate date2;
	private LocalDate date3;
	private LocalDate emulatedTodayDate;
	
	@BeforeEach
	void setUp () {
		person1 = new Personals("first", "last", "example@example.com", "pass");
		person2 = new Personals("first2", "last2", "example2@example.com", "pass");
		person3 = new Personals("first3", "last3", "example3@example.com", "pass3");
		
		date1 = LocalDate.of(2000, 1, 25);
		date2 = LocalDate.of(1997, 1, 25);
		date3 = LocalDate.of(1999, 8, 25);
		emulatedTodayDate = LocalDate.of(2000, 2, 1);
	}
	
	@Test
	public void testCheckMembers () {
		System.out.println(String.format("Date1: %s, Date2: %s, Emulated today date: %s", date1, date2, emulatedTodayDate));
		
		MemberArchive memberArchive = new MemberArchive();
		int id1 = memberArchive.addMember(person1, date1);
		int id2 = memberArchive.addMember(person2, date2);
		int id3 = memberArchive.addMember(person3, date3);
		memberArchive.registerPoints(id2, (int)MemberArchive.SILVER_LIMIT + 1);
		memberArchive.registerPoints(id3, (int)MemberArchive.SILVER_LIMIT + 1);
		
		memberArchive.checkMembers(emulatedTodayDate);
		
		System.out.println("Check if person1 is BasicMember");
		assertEquals(true, (memberArchive.getMember(id1) instanceof BasicMember));
		
		System.out.println("Check if person2 is still BasicMember (been too long)");
		assertEquals(true, (memberArchive.getMember(id2) instanceof BasicMember));
		
		System.out.println("Check if person3 is upgraded to SilverMember (has enough points)");
		assertEquals(true, (memberArchive.getMember(id3) instanceof SilverMember));
	}
	
}
