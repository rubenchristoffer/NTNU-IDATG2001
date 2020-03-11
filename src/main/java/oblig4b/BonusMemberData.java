package oblig4b;

import java.time.LocalDate;

import oblig2.Personals;

public class BonusMemberData {

	private Personals personals;
	private LocalDate localDate;
	
	public BonusMemberData(Personals personals, LocalDate localDate) {
		this.personals = personals;
		this.localDate = localDate;
	}

	public Personals getPersonals() {
		return personals;
	}
	
	public LocalDate getLocalDate() {
		return localDate;
	}
	
}
