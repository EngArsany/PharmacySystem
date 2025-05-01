package PharmacySys;

import java.util.ArrayList;

public class Stock {

	private static ArrayList<Item> products;

	public Stock() {
		products = new ArrayList<>();
		initializeProducts();
	}

	public static ArrayList<Item> getProductList() {
		return new ArrayList<>(products); // Returning a copy to protect the original list
	}

	private void initializeProducts() {
		// Morphine
		products.add(new Morphine("12"));

		// Steroids
		products.add(new Steroids("13"));

		// Paracetamol
		products.add(new Paracetamol(12.75, "P001", "Panadol", 6, 100, "Oral", "Take 1 tablet every 6 hours", 20));
		products.add(new Paracetamol(9.50, "P002", "Tylenol", 10, 80, "Oral", "Take 2 tablets after meals", 16));

		// Multivitamins
		products.add(new Multivitamins(29.99, "MV001", "VitalBoost", 18, 50, "Unisex", "Ginseng"));
		products.add(new Multivitamins(34.50, "MV002", "EnergyPlus", 12, 30, "Male", "Coenzyme Q10"));

		// Shampoo
		products.add(new Shampoo(15.99, "S001", "SilkSmooth", 5, 60, "Female", "Lavender"));
		products.add(new Shampoo(13.49, "S002", "Clear", 8, 40, "Male", "Mint"));

		// Skincare
		products.add(new Skincare(22.00, "SC001", "GlowGuard", 16, 35, "Female", "sun protection"));
		products.add(new Skincare(18.75, "SC002", "ClearTone", 14, 50, "Unisex", "cleansing"));

	} // for better readability

	public static Item findItemByName(String name) throws Item.ItemNotFoundException {
		for (Item product : products) {
			if (product.getName().equalsIgnoreCase(name)) {
				return product;
			}
		}
		throw new Item.ItemNotFoundException("Item '" + name + "' not found in stock"); // handled here and in order class also
	}

}
