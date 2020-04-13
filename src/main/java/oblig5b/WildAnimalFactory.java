package oblig5b;

import java.time.LocalDate;

/**
 * Factory class for generating wild animal objects.
 * @author R.C. Hegland-Antonsen
 */
public final class WildAnimalFactory {

	public static ScandinavianWildAnimal newMaleBear(LocalDate arrivalDate, String name,
			LocalDate dateOfBirth, String address) {
		return new MaleIndividual("Bjørn", "Ursus arctos", "Ursidae", arrivalDate, name, dateOfBirth, true, address);
	}

	public static ScandinavianWildAnimal newFemaleWolf(LocalDate arrivalDate, String name,
			LocalDate dateOfBirth, String address, int noLitters) {
		return new FemaleIndividual("Ulv", "Canis lupus", "Canidae", arrivalDate, name, dateOfBirth, true, address, noLitters);
	}

	public static ScandinavianWildAnimal newMaleWolf(LocalDate arrivalDate, String name,
			LocalDate dateOfBirth, String address) {
		return new MaleIndividual("Ulv", "Canis lupus", "Canidae", arrivalDate, name, dateOfBirth, true, address);
	}

}
