package PharmacySys;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        // intializing stock
        new Stock();
        List<Item> productList = Stock.getProductList();

        // Print sorted product list using describe() methods according to ID
        System.out.println("============== PHARMACY STOCK ITEMS ===============");
        System.out.println("           ===========================");
        System.out.println("");

        // === Sort & Print Medicines ===
        List<Medicine> medicines = new ArrayList<>();
        for (Item item : productList) {
            if (item instanceof Medicine) {
                medicines.add((Medicine) item);
            }
        }
        System.out.println("============== SORTED MEDICINES (BY ID) ==============");
        Collections.sort(medicines);  // Uses inherited compareTo()
        for (Medicine med : medicines) {
            med.describe();
            System.out.println("-------------------------------------------------");
        }
        System.out.println(" ");

        // === Sort & Print PersonalCare ===
        List<PersonalCare> personalCareItems = new ArrayList<>();
        for (Item item : productList) {
            if (item instanceof PersonalCare) {
                personalCareItems.add((PersonalCare) item);
            }
        }
        Collections.sort(personalCareItems);  // Uses inherited compareTo()
        System.out.println("=========== SORTED PERSONAL CARE (BY ID) ===========");
        for (PersonalCare pc : personalCareItems) {
            pc.describe();
            System.out.println("-------------------------------------------------");

        }

        // try - catch block for ordering and printing recipt
        try {
            System.out.println("Processing Order");

            // Create order array - note the exact product names must match (case-insensitive)
            ArrayList<Order> order1 = new ArrayList<>(List.of(new Order("Morphine", 10),
                    new Order("Steroids", 6),
                    new Order("Panadol", 6),
                    new Order("Tylenol", 6),
                    new Order("VitalBoost", 6),
                    new Order("EnergyPlus", 6),
                    new Order("SilkSmooth", 6),
                    new Order("Clear", 6),
                    new Order("GlowGuard", 6),
                    new Order("ClearTone", 6)));

// Process receipt
            Receipt receipt1 = new Receipt(order1);
            receipt1.printReceipt();

        } catch (Exceptions.ItemNotFoundException e) {
            System.err.println("Order Failed - " + e.getMessage());
            // You could add recovery logic here, like suggesting similar products
        } catch (Exceptions.InsufficientStockException e) {
            System.err.println("Order Failed - " + e.getMessage());
            // Could suggest partial fulfillment or backorder
        } catch (IllegalArgumentException e) {
            System.err.println("Order Failed - " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Order Failed - " + "unexpected behaviour");
            e.printStackTrace();
        }

        /// Print product list using describe() methods
		System.out.println("============== PHARMACY STOCK ITEMS ===============");
        System.out.println("           ===========================");
        System.out.println("");

        // === Sort & Print Medicines ===
        for (Item item : productList) {
            if (item instanceof Medicine) {
                medicines.add((Medicine) item);
            }
        }

        Collections.sort(medicines);  // Uses Medicine's compareTo()
        System.out.println("============== SORTED MEDICINES (BY ID) ==============");
        for (Medicine med : medicines) {
            med.describe();
        }
        System.out.println(" ");

        // === Sort & Print PersonalCare ===
        for (Item item : productList) {
            if (item instanceof PersonalCare) {
                personalCareItems.add((PersonalCare) item);
            }
        }

        Collections.sort(personalCareItems);  // Uses PersonalCare's compareTo()
        System.out.println("=========== SORTED PERSONAL CARE (BY ID) ===========");
        for (PersonalCare pc : personalCareItems) {
            pc.describe();
        }

        // taking order #2
        try {
            System.out.println("Processing Order");

            // Create order array - note the exact product names must match (case-insensitive)
            ArrayList<Order> order2 = new ArrayList<>();
            order2.add(new Order("panadol", 2));
            order2.add(new Order("clear", 1));

            Receipt receipt2 = new Receipt(order2);
            receipt2.printReceipt();

        } catch (Exceptions.ItemNotFoundException e) {
            System.err.println("Order Failed - " + e.getMessage());
            // You could add recovery logic here, like suggesting similar products
        } catch (Exceptions.InsufficientStockException e) {
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
