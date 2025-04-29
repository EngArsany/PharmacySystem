package PharmacySys;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		new Stock();
		List<Item> productList = Stock.getProductList();
		/*
		 * To check the stock for(Item item:productList) {
		 * System.out.println(item.getName()); }
		 */
		/*
		 * // Morphine Morphine morphine = new Morphine("12");
		 * 
		 * // Steroids Steroids steroids = new Steroids("13");
		 * 
		 * // Paracetamol Paracetamol panadol = new Paracetamol(12.75, "P001",
		 * "Panadol", 6, 100, "Oral", "Take 1 tablet every 6 hours", 20); Paracetamol
		 * tylenol = new Paracetamol(9.50, "P002", "Tylenol", 10, 80, "Oral",
		 * "Take 2 tablets after meals", 16);
		 * 
		 * // Multivitamins Multivitamins vitalBoost = new Multivitamins(29.99, "MV001",
		 * "VitalBoost", 18, 50, "Unisex", "Ginseng"); Multivitamins energyPlus = new
		 * Multivitamins(34.50, "MV002", "EnergyPlus", 12, 30, "Male", "Coenzyme Q10");
		 * 
		 * // Shampoo Shampoo silkSmooth = new Shampoo(15.99, "S001", "SilkSmooth", 5,
		 * 60, "Female", "Lavender"); Shampoo clear = new Shampoo(13.49, "S002",
		 * "Clear", 8, 40, "Male", "Mint");
		 * 
		 * // Skincare Skincare glowGuard = new Skincare(22.00, "SC001", "GlowGuard",
		 * 16, 35, "Female", "sun protection"); Skincare clearTone = new Skincare(18.75,
		 * "SC002", "ClearTone", 14, 50, "Unisex", "cleansing");
		 * 
		 */

		// ===Order Making===
		Order[] order1 = { new Order("morphine", 3), new Order("steroids", 6), new Order("panadol", 6),
				new Order("tylenol", 6), new Order("vitalBoost", 6), new Order("energyPlus", 6),
				new Order("silkSmooth", 6), new Order("clear", 6), new Order("glowGuard", 6),
				new Order("clearTone", 6), };

		Receipt receipt1 = new Receipt(order1);
		receipt1.printReceipt();

		Order[] order2 = { new Order("panadol:", 2), new Order("clear", 1) };

		Receipt receipt2 = new Receipt(order2);
		receipt2.printReceipt();

	}

}
