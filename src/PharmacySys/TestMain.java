
package PharmacySys;
import java.time.LocalDate;
/*
public  class TestMain {
    
    public static void main(String[] args) {

        // Creating instances of different item types (Medicine, PersonalCare)
        System.out.println("\n=== Testing Paracetamol ===");
        Paracetamol paracetamol = new Paracetamol("Paracetamol", 10, 500);
        System.out.println(paracetamol.itemDetails());
        System.out.println("Price: " + paracetamol.getPrice());
        System.out.println("Stock before decrease: " + Paracetamol.paracetamolStock);
        paracetamol.decreasStock();
        System.out.println("Stock after decrease: " + Paracetamol.paracetamolStock);

        System.out.println("\n=== Testing Morphine ===");
        Morphine morphine = new Morphine("Morphine", 5, 1000);
        System.out.println(morphine.itemDetails());
        System.out.println("Price: " + morphine.getPrice());
        System.out.println("Stock before decrease: " + Morphine.MorphineStock);
        morphine.decreasStock();
        System.out.println("Stock after decrease: " + Morphine.MorphineStock);

        System.out.println("\n=== Testing Steroids ===");
        Steroids steroids = new Steroids("Steroids", 3);
        System.out.println(steroids.itemDetails());
        System.out.println("Price: " + steroids.getPrice());
        System.out.println("Stock before decrease: " + Steroids.steroidsStock);
        steroids.decreasStock();
        System.out.println("Stock after decrease: " + Steroids.steroidsStock);

        System.out.println("\n=== Testing Shampoo ===");
        Shampoo shampoo = new Shampoo("Shampoo", 20, "Female", "Mint");
        System.out.println(shampoo.itemDetails());
        System.out.println("Price: " + shampoo.getPrice());
        System.out.println("Stock before decrease: " + Shampoo.shampooStock);
        shampoo.decreasStock();
        System.out.println("Stock after decrease: " + Shampoo.shampooStock);

        System.out.println("\n=== Testing Multivitamins ===");
        Multivitamins multivitamins = new Multivitamins("Multivitamins", 15, "Vitamin C");
        System.out.println(multivitamins.itemDetails());
        System.out.println("Price: " + multivitamins.getPrice());
        System.out.println("Stock before decrease: " + Multivitamins.MultivitaminsreStock);
        multivitamins.decreasStock();
        System.out.println("Stock after decrease: " + Multivitamins.MultivitaminsreStock);

        // Testing Skincare class
        System.out.println("\n=== Testing Skincare ===");
        Skincare skincare = new Skincare("Skincare", 10, "Cleansing");
        System.out.println(skincare.itemDetails());
        System.out.println("Price: " + skincare.getPrice());
        System.out.println("Stock before decrease: " + Skincare.skinCareStock);
        skincare.decreasStock();
        System.out.println("Stock after decrease: " + Skincare.skinCareStock);

        // Testing Order Class
        System.out.println("\n=== Creating an Order ===");
        Item[] orderItems = { paracetamol, morphine, steroids, shampoo, multivitamins, skincare };
        Order order = new Order(orderItems);
        System.out.println("Total Price of Order: " + order.totalPrice + " EGP");
        System.out.println("Order processed on: " + LocalDate.now());

        // Testing Medicine methods and safety check for age
        System.out.println("\n=== Testing Medicine Dosage Safety ===");
        System.out.println("Is dosage safe for 25 years old? " + morphine.isDosageSafeForAge(25));
        System.out.println("Is dosage safe for 10 years old? " + morphine.isDosageSafeForAge(10));

        // Testing generic item details
        System.out.println("\n=== Testing Item Details for All Items ===");
        System.out.println(paracetamol.itemDetails());
        System.out.println(morphine.itemDetails());
        System.out.println(steroids.itemDetails());
        System.out.println(shampoo.itemDetails());
        System.out.println(multivitamins.itemDetails());
        System.out.println(skincare.itemDetails());
    }


}*/
