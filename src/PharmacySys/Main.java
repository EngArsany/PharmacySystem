package PharmacySys;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // intializing stock
        new Stock();
        //Encapsulation: all data and methods related to the stock is in the Stock class

        //Program Header
        System.out.println("============== PHARMACY STOCK Program ===============");
        System.out.println("           ===========================");
        System.out.println("");

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

        // Print sorted product list using describe() methods according to ID
        // === Sort & Print All Items in short form ===
        Stock.viewProductList();    //Short list to check sorting
        Stock.describeList();   //Long list to check inheritance and polymorphism

    }

}
