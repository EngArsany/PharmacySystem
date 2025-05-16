package com.mycompany.project_draft1;

import java.util.ArrayList;
import java.util.Collections;

public class Stock {

    private static ArrayList<Item> products = new ArrayList<>();

    public Stock() {
        initializeProducts();
    }

    public static ArrayList<Item> getProductList() {
        return products; // Returning a copy to protect the original list
    }

    private void initializeProducts() {
        // Morphine
        products.add(new Morphine("02MH012"));

        // Steroids
        products.add(new Steroids("03ST013"));

        // Paracetamol
        products.add(new Paracetamol(12.75, "01PA001", "Panadol", 15, 100, "Oral", "Take 1 tablet every 6 hours", 20));
        products.add(new Paracetamol(9.50, "01PA002", "Tylenol", 15, 80, "Oral", "Take 2 tablets after meals", 16));

        // Multivitamins
        products.add(new Multivitamins(29.99, "11MV001", "VitalBoost", 5, 50, "Unisex", "Ginseng"));
        products.add(new Multivitamins(34.50, "11MV002", "EnergyPlus", 10, 30, "Men", "Coenzyme Q10"));

        // Shampoo
        products.add(new Shampoo(15.99, "12SH001", "SilkSmooth", 5, 60, "Women", "Lavender"));
        products.add(new Shampoo(13.49, "12SH002", "Clear", 8, 40, "Men", "Mint"));

        // Skincare
        products.add(new Skincare(22.00, "13SC001", "GlowGuard", 7, 35, "Women", "sun protection"));
        products.add(new Skincare(18.75, "13SC002", "ClearTone", 12, 50, "Unisex", "cleansing"));

    } // for better readability

    public static Item findItemByName(String name) throws Exceptions.ItemNotFoundException {
        for (Item product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        throw new Exceptions.ItemNotFoundException("Item '" + name + "' not found in stock"); // handled here 
    }

    public static void viewProductList() {
        //Print list of items in numerical 
        System.out.println("============== SORTED PRODUCTS (BY ID) ==============");
        Collections.sort(products);
        for (int i = 0; i < products.size(); i++) {
            System.out.println(
                    (i + 1) + ". " + products.get(i).getName() + " - ID: " + products.get(i).getID() + " - Qty: " + products.get(i).getStock()
            );
        }
        System.out.println("");
    }

    public static void describeList() {
        System.out.println("============== Details of All Products ==============");

        for (Item item : products) {
            item.describe();
            if (item instanceof Scheduled) {
                System.out.println("Need Prescription");
            }
            if (item instanceof SuitableForChildren) {
                System.out.println("Suitable for children use");
            }
            System.out.println("-------------------------------------------------");
        }

    }
}
