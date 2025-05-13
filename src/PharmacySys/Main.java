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

        // === Sort & Print All Items ===
        System.out.println("============== SORTED PRODUCTS (BY ID) ==============");
        Collections.sort(productList);
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(
                    (i + 1) + ". " + productList.get(i).getName() + " - ID: " + productList.get(i).getID()
            );
        }
        System.out.println("");

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

        // try - catch block for ordering and printing recipt
        try {
            System.out.println("Processing Order 1");

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
        } catch (Exceptions.ItemNotFoundException | Exceptions.InsufficientStockException | IllegalArgumentException e) {
            //Use multicatch to reduce redundancy
            System.err.println("Order Failed - " + e.getMessage());
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
        } catch (Exceptions.ItemNotFoundException | Exceptions.InsufficientStockException | IllegalArgumentException e) {
            System.err.println("Order Failed - " + e.getMessage());
        }
    }

}
