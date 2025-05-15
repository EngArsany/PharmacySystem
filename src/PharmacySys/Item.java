package PharmacySys;

// Abstract class representing a general item in the pharmacy system
public abstract class Item implements Comparable<Item> {

    // Basic attributes of any item
    private String name;
    private String ID;
    private double price;
    private int stock; // Items available
    private int minimumAge;

    // Full constructor used when all item properties are known
    public Item(double price, String ID, String name, int minimumAge, int stock) {
        this.price = price;
        this.ID = ID;
        this.name = name;
        this.stock = stock;
        this.minimumAge = minimumAge;
    }

    // Getters to access private attributes
    public double getPrice() {
        return price;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public int getMinimumAge() {
        return minimumAge;
    }

    // Method to reduce stock when ordering
    public void decreaseStock(int quantity) throws Exceptions.InsufficientStockException {
        if (quantity <= 0) { // if quantity is negative
            throw new IllegalArgumentException("Quantity of \"" + this.getName() + "\" must be a positive number. You entered: " + quantity);
        }
        if (quantity > stock) { // if quantity  > stock
            throw new Exceptions.InsufficientStockException(
                    "Insufficient stock. Requested: " + quantity + ", Available: " + stock
            );
        }
        this.stock -= quantity; //implementation
    }

    // Utility method to describe the item
    public void describe() {
        System.out.println("Product Name: " + this.getName());
        System.out.println("Product Price: " + this.getPrice());
        System.out.println("Product ID: " + this.getID());
        System.out.println("Amount in Stock: " + this.getStock());
        System.out.println("Minimum Age: " + this.getMinimumAge());
    }

    @Override
    public int compareTo(Item other) {
        return this.getID().compareTo(other.getID());  // Sort Item instances by ID
    }

}
