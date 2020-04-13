package oblig5b;

import java.time.LocalDate;

/**
 * Factory class for generating wild animal objects.
 * @author R.C. Hegland-Antonsen
 */
public final class WildAnimalFactory {

	public ScandinavianWildAnimal newMaleBear(String norName, String latName, LocalDate arrivalDate, String name,
			LocalDate dateOfBirth, String address) {
		return new MaleIndividual(norName, latName, "Ursidae", arrivalDate, name, dateOfBirth, true, address);
	}

	public ScandinavianWildAnimal newFemaleWolf(String norName, String latName, LocalDate arrivalDate, String name,
			LocalDate dateOfBirth, String address, int noLitters) {
		return new FemaleIndividual(norName, latName, "Canidae", arrivalDate, name, dateOfBirth, true, address, noLitters);
	}

	public ScandinavianWildAnimal newMaleWolf(String norName, String latName, LocalDate arrivalDate, String name,
			LocalDate dateOfBirth, String address) {
		return new MaleIndividual(norName, latName, "Canidae", arrivalDate, name, dateOfBirth, true, address);
	}

}
