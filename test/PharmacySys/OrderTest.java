package PharmacySys;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class OrderTest {

	@Before
	public void setUp() {
		new Stock(); // Reset stock before each test
	}

	@Test // this is test 1 that checks the getter methods
	public void testGetters() throws Exception {
		Order order = new Order("Panadol", 2);

		assertEquals("Panadol", order.getItemName()); // it checks the getter method of getitemName
		assertEquals(2, order.getQuantity()); // it checks the getter methods of getQuantity
		assertEquals(25.50, order.getOrderPrice(), 0.01); // it checks the getter methods of getQuantity and should return 12.5*2
	}

	// Test 2: does it fails when ordering items that are not in stock ?
	@Test
	public void testNotFoundItem() {
		Exception e = assertThrows(Exception.class, () -> {
			new Order("FakeMedicine", 1);
		});
		assertTrue(e.getMessage().contains("not found in stock"));
	}

	// Test 3: Does it fails when ordering more than stock quantity ?
	@Test
	public void testInsufficientStock() {
		Exception e = assertThrows(Exception.class, () -> {
			new Order("Panadol", 200); // trying to order items more than found in stock
		});
		assertTrue(e.getMessage().contains("Insufficient stock"));
	}

	// Test 4: Does it calculate the price correctly?
	@Test
	public void testPriceCalculation() throws Exception {
		Order order1 = new Order("Panadol", 3);
		assertEquals(38.25, order1.getOrderPrice(),0.001); // 12.75 * 3

		Order order2 = new Order("Tylenol", 4);
		assertEquals(38.00, order2.getOrderPrice(),0.001); // 9.50 * 4
	}

	// Test 5: Does it reduce the stock correctly?
	@Test
	public void testDecreaseItem() throws Exception {
		Item panadolBefore = Stock.findItemByName("Panadol");
		int initialStock = panadolBefore.getStock();// it saves the number of pandols found in stock in intialStock = 100 

		new Order("Panadol", 5); // Ordering 5 panadols

		Item panadolAfter = Stock.findItemByName("Panadol");
		assertEquals(initialStock - 5, panadolAfter.getStock()); // should return 95
	}
}
