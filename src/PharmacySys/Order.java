package PharmacySys;

public class Order {
	private Item item;
	private double OrderPrice;
	private int quantity;

	public Order(String itemName, int quantity) throws Item.InsufficientStockException { // declared that it will throw an exception

		// Add exception handling if the item is not in the list (stock)
		// Create new order
		this.item = Stock.findItemByName(itemName);
		this.quantity = quantity;
		this.OrderPrice = item.getPrice() * quantity;

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
		System.out.println("Quantity Ordered: " + quantity);
		System.out.println("Price per Unit: " + item.getPrice() + " EGP");
		System.out.println("Subtotal Price: " + OrderPrice + " EGP");

	}
}
