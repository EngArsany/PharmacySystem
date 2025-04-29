package PharmacySys;

public abstract class Medicine extends Item implements Dosable {

	private String dosageInstructions;
	private String adminstrationRoute;

	public Medicine(double price, String ID, String name, int minimumAge, int stock, String adminstrationRoute,
			String dosageInstructions) {
		super(price, ID, name, minimumAge, stock);
		this.adminstrationRoute = adminstrationRoute;
		this.dosageInstructions = dosageInstructions;

	}

	// Getters for the medicine's properties
	@Override
	public String getDosageInstructions() {
		// Dosable Interface method
		return dosageInstructions;
	}

	@Override
	public String getAdministrationRoute() {
		// Dosable Interface method
		return adminstrationRoute;
	}

	// Check if the medicine is safe based on patient's age
	@Override
	public boolean isDosageSafeForAge(int ageInYears) {
		// Dosable Interface method
		return ageInYears >= this.getMinimumAge();
	}

	@Override // From Item Class
	public void describe() {
		super.describe();
		System.out.println("Dosage Instructions: " + this.getDosageInstructions());
		System.out.println("Administration Route: " + this.getAdministrationRoute());
	}

}
