package PharmacySys;

import java.util.ArrayList;
import java.util.Collections;

public class Stock {

	private static ArrayList<Item> products;

	public Stock() {
		products = new ArrayList<>();
		initializeProducts();
		Collections.sort(products); // ✅ Sorts by ID (via compareTo in Item)
	}

	public static ArrayList<Item> getProductList() {
		return new ArrayList<>(products); // Returning a copy to protect the original list
	}

	private void initializeProducts() {
		// Morphine
		products.add(new Morphine("02MH012"));

		// Steroids
		products.add(new Steroids("03ST013"));

		// Paracetamol
		products.add(new Paracetamol(12.75, "01PA001", "Panadol", 6, 100, "Oral", "Take 1 tablet every 6 hours", 20));
		products.add(new Paracetamol(9.50, "01PA002", "Tylenol", 10, 80, "Oral", "Take 2 tablets after meals", 16));

		// Multivitamins
		products.add(new Multivitamins(29.99, "11MV001", "VitalBoost", 18, 50, "Unisex", "Ginseng"));
		products.add(new Multivitamins(34.50, "11MV002", "EnergyPlus", 12, 30, "Male", "Coenzyme Q10"));

		// Shampoo
		products.add(new Shampoo(15.99, "12SH001", "SilkSmooth", 5, 60, "Female", "Lavender"));
		products.add(new Shampoo(13.49, "12SH002", "Clear", 8, 40, "Male", "Mint"));

		// Skincare
		products.add(new Skincare(22.00, "13SC001", "GlowGuard", 16, 35, "Female", "sun protection"));
		products.add(new Skincare(18.75, "13SC002", "ClearTone", 14, 50, "Unisex", "cleansing"));

	} // for better readability

	public static Item findItemByName(String name) throws Exceptions.ItemNotFoundException {
		for (Item product : products) {
			if (product.getName().equalsIgnoreCase(name)) {
				return product;
			}
		}
		throw new Exceptions.ItemNotFoundException("Item '" + name + "' not found in stock"); // handled here and in order class also
	}

}
