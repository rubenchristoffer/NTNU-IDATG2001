package oblig5b;

import java.time.LocalDate;

public final class App {

	public static void main (String[] args) {
		WildAnimalFactory waf = new WildAnimalFactory();
		
		ScandinavianWildAnimal ulla = waf.newFemaleWolf(LocalDate.of(2015,4,29), "Ulla",  LocalDate.of(2015,2,26), "Innhegning 2, Skandinaviske rovdyr", 2);
		ScandinavianWildAnimal truls = waf.newMaleWolf(LocalDate.of(2015,4,29), "Truls",  LocalDate.of(2015,2,26), "Innhegning 2, Skandinaviske rovdyr");
		ScandinavianWildAnimal bjornar = waf.newMaleBear(LocalDate.of(2012, 5, 5), "Bjørnar", LocalDate.of(2011, 5, 5), "Innhegning 3, Skandinaviske rovdyr");
	}
	
}
