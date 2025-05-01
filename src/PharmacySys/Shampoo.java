package PharmacySys;

public class Shampoo extends PersonalCare implements SuitableForChildren {

	private String flavor; // Mint, Coal, Jasmine.. etc.

	public Shampoo(double price, String ID, String name, int minimumAge, int stock, String gender, String flavor) {
		super(price, ID, name, minimumAge, stock, gender);
		this.flavor = flavor;
	}

	public String getflavor() {
		return flavor;
	}

	@Override
	public void describe() {
		super.describe();
		System.out.println("Flavour: " + flavor);
	}

}
