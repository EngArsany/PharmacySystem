package com.mycompany.project_draft1;

public class Order {

    private Item item;
    private double OrderPrice;
    private int quantity;

    public Order(String itemName, int quantity) throws Exceptions.InsufficientStockException, Exceptions.ItemNotFoundException { // declared that it will throw an exception

        // Create new order
        this.item = Stock.findItemByName(itemName); // Add exception handling if the item is not in the list (stock)
        this.quantity = quantity;
        item.decreaseStock(quantity); // threw exception in item class if there is a problem in quantity
        this.OrderPrice = item.getPrice() * quantity;

    }

    public Order(Item item) throws Exceptions.InsufficientStockException, Exceptions.ItemNotFoundException { // declared that it will throw an exception

        // Add exception handling if the item is not in the list (stock)
        this.item = item;

        // Create new order
        this.quantity = 1;
        this.OrderPrice = item.getPrice();

        // Exception handling if quantity > stock
        item.decreaseStock(quantity);
    }

    public double getOrderPrice() {
        return OrderPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public Item getItem() {
        return item;
    }

    public String getItemName() {
        return item.getName();
    }

    public void describeOrder() {
        System.out.println("Item Ordered: " + item.getName());
        System.out.println("Quantity Ordered: " + this.quantity);
        System.out.println("Price per Unit: " + item.getPrice() + " EGP");
        System.out.println("Subtotal Price: " + this.OrderPrice + " EGP");

    }
}
