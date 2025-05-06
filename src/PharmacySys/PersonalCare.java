package PharmacySys;

public abstract class PersonalCare extends Item implements Comparable<PersonalCare> {

	private String gender;

	public PersonalCare(double price, String ID, String name, int minimumAge, int stock, String gender) {
		super(price, ID, name, minimumAge, stock);
		this.gender = gender;
	}

	public String getGender() {
		return gender;

	}

	@Override
	public void describe() {
		super.describe();
		System.out.println("Product for: " + gender);
		System.out.println("-------------------------------------------------");
	}

	@Override
	public int compareTo(PersonalCare other) {
		return this.getID().compareTo(other.getID());  // Sort PersonalCare instances by ID
	}
}
