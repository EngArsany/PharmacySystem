package PharmacySys;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Main {
    static List<Item> productList;

    public static void main(String[] args) {
        // intializing stock
        new Stock();
        productList = Stock.getProductList();

        //Program Header
        System.out.println("============== PHARMACY STOCK Program ===============");
        System.out.println("           ===========================");
        System.out.println("");

        // Print sorted product list using describe() methods according to ID
        // === Sort & Print All Items ===
        Stock.viewAllProducts();

        // === Sort Medicine & PersonalCare items ===
        List<Medicine> medicines = new ArrayList<>();
        List<PersonalCare> personalCareItems = new ArrayList<>();
        for (Item item : productList) {
            if (item instanceof Medicine) {
                medicines.add((Medicine) item);
            } else if (item instanceof PersonalCare) {
                personalCareItems.add((PersonalCare) item);
            }

        }
        Collections.sort(medicines);  // Uses inherited compareTo()
        Collections.sort(personalCareItems);  // Uses inherited compareTo()

        //Print Medicine Items
        System.out.println("============== SORTED MEDICINES (BY ID) ==============");
        for (Medicine med : medicines) {
            med.describe();
            System.out.println("-------------------------------------------------");
        }
        System.out.println(" ");

        // === Print PersonalCare ===
        System.out.println("=========== SORTED PERSONAL CARE (BY ID) ===========");
        for (PersonalCare pc : personalCareItems) {
            pc.describe();
            System.out.println("-------------------------------------------------");

        }
        System.out.println(" ");

        //== Order #1 ==
        // try - catch block for ordering and printing recipt
        try {
            System.out.println("=============== PROCESSING ORDER 1 ===============");

            // Create order array
            ArrayList<Order> order1 = new ArrayList<>(List.of(
                    new Order("Morphine", 10),
                    new Order("steroids", 6),
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
        } catch (Exceptions.ItemNotFoundException | Exceptions.InsufficientStockException | IllegalArgumentException e) {
            //Use multicatch to reduce redundancy
            System.err.println("Order Failed - " + e.getMessage());
        }

/*
        //=== Code for reviewing stock ===
        // Print product list using describe() methods
	System.out.println("============== PHARMACY STOCK ITEMS ===============");
        System.out.println("           ===========================");
        System.out.println("");

        System.out.println("============== SORTED MEDICINES (BY ID) ==============");
        for (Medicine med : medicines) {
            med.describe();
        }
        System.out.println(" ");

        System.out.println("=========== SORTED PERSONAL CARE (BY ID) ===========");
        for (PersonalCare pc : personalCareItems) {
            pc.describe();
        }
*/

        // taking order #2
        try {
            System.out.println("=============== PROCESSING ORDER 2 ===============");

            // Create order array - note the exact product names must match (case-insensitive)
            ArrayList<Order> order2 = new ArrayList<>();
            order2.add(new Order("panadol", 2));
            order2.add(new Order("clear", 1));

            Receipt receipt2 = new Receipt(order2);
            receipt2.printReceipt();
        } catch (Exceptions.ItemNotFoundException | Exceptions.InsufficientStockException | IllegalArgumentException e) {
            System.err.println("Order Failed - " + e.getMessage());
        }
    }

}
