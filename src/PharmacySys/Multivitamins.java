package PharmacySys;

// Multivitamins class represents a personal care item that is suitable for children and has dosage features
public class Multivitamins extends PersonalCare implements SuitableForChildren, Dosable {

	private String effectiveSubstance;

	public Multivitamins(double price, String ID, String name, int minimumAge, int stock, String gender,
			String effectiveSubstance) {
		super(price, ID, name, minimumAge, stock, gender);
		this.effectiveSubstance = effectiveSubstance;

	}

	public String getEffectiveSubstance() {
		return effectiveSubstance;
	}

	@Override
	public String getDosageInstructions() {
		return " Before sleep"; // Always
	}

	@Override
	public String getAdministrationRoute() {
		return "Skin"; // Always
	}

	@Override
	public boolean isDosageSafeForAge(int age) {
		return true; // Always safe in this simplified version
	}

}
