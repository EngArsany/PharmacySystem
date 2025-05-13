package com.mycompany.project_draft1;

//Java Program to illustrate LocalDateTime Class by
//Formatting LocalDateTime to string

//Importing all classes from java.time package
import java.time.LocalDateTime;
import java.time.format.*;
import java.util.ArrayList;

public class Receipt {

	private ArrayList<Order> orders;
	private int itemsCounter = 0;
	private float totalPrice = 0;
	private static int numberOfReceiptsMade = 0;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");

	public Receipt(ArrayList<Order> orders) {
		this.orders = orders;
		numberOfReceiptsMade++;

		for (Order order : orders) {
			totalPrice += order.getOrderPrice();
			itemsCounter++;
		}

	}

	public static int getNumberOfReceiptsMade() {
		return numberOfReceiptsMade;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void printReceipt() {

		// Receipt header
		System.out.println("Receipt no. #" + getNumberOfReceiptsMade());
		System.out.println("------------------");

		// Ordered items and individual prices
		for (Order order : orders) {
			order.describeOrder();
			System.out.println("------------------");
		}

		// Receipt Footer
		receiptSummary();
		System.out.println("=======================");
	}

	public void receiptSummary() {
		System.out.println("Total number of items: " + itemsCounter);
		System.out.println("Total price: " + totalPrice);
		System.out.println("Date: " + LocalDateTime.now().format(formatter));
	}

}
