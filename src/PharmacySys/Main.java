package PharmacySys;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		// intializing stock
		new Stock();
		List<Item> productList = Stock.getProductList();

		// Print product list using describe() methods
		System.out.println("=========== PHARMACY STOCK ITEMS ============");
		System.out.println("=============================================");

		for (Item item : productList) {
			item.describe();  // This will call the appropriate describe() for each item type
			System.out.println("-----------------------------");
		}

		// try - catch block for ordering and printing recipt
		try {
			System.out.println("Processing Order");

			// Create order array - note the exact product names must match (case-insensitive)
			Order[] order1 = {
				new Order("Morphine", 10),
				new Order("Steroids", 6),
				new Order("Panadol", 6),
				new Order("Tylenol", 6),
				new Order("VitalBoost", 6),
				new Order("EnergyPlus", 6),
				new Order("SilkSmooth", 6),
				new Order("Clear", 6),
				new Order("GlowGuard", 6),
				new Order("ClearTone", 6)
			};

			// Process receipt
			Receipt receipt1 = new Receipt(order1);
			receipt1.printReceipt();

		} catch (Item.ItemNotFoundException e) {
			System.err.println("Order Failed - " + e.getMessage());
			// You could add recovery logic here, like suggesting similar products
		} catch (Item.InsufficientStockException e) {
			System.err.println("Order Failed - " + e.getMessage());
			// Could suggest partial fulfillment or backorder
		} catch (IllegalArgumentException e) {
			System.err.println("Order Failed - " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Order Failed - " + "unexpected behaviour");
			e.printStackTrace();
		}

		// Print product list after ordering order number 1
		System.out.println("=========== PHARMACY STOCK ITEMS ============");
		System.out.println("=============================================");

		for (Item item : productList) {
			item.describe();  // This will call the appropriate describe() for each item type
			System.out.println("-----------------------------");
		}

		// To check the stock items and quantity
		for (Item item : productList) {
			System.out.println(item.getName() + " (stock: " + item.getStock() + ") ");
		}
		System.out.println("===========================================");

		// taking order #2
		try {
			System.out.println("Processing Order");

			// Create order array - note the exact product names must match (case-insensitive)
			Order[] order2 = {
				new Order("panadol", 2),
				new Order("clear", 1)
			};

			Receipt receipt2 = new Receipt(order2);
			receipt2.printReceipt();

		} catch (Item.ItemNotFoundException e) {
			System.err.println("Order Failed - " + e.getMessage());
			// You could add recovery logic here, like suggesting similar products
		} catch (Item.InsufficientStockException e) {
			System.err.println("Order Failed - " + e.getMessage());
			// Could suggest partial fulfillment or backorder
		} catch (IllegalArgumentException e) {
			System.err.println("Order Failed - " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Order Failed - " + "unexpected behaviour");
			e.printStackTrace();
		}
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
		
	}

}
