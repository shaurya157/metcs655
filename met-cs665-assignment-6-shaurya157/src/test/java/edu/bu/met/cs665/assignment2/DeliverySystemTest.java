package edu.bu.met.cs665.assignment2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class DeliverySystemTest {


	@BeforeClass
	public static void init() {
		NotificationService.reset();
		CommonDeliveryCart.reset();
	}

	@Test
	public void testDeliveryRequestNotification() {
		Shop shop = new Shop("City Shop", "address");
		Driver driver1 = new Driver("driver1", "12345");
		Driver driver2 = new Driver("driver2", "98765");
		Driver driver3 = new Driver("driver3", "43556");
		Driver driver4 = new Driver("driver4", "3786");
		Driver driver5 = new Driver("driver5", "32456");
		Driver driver6 = new Driver("driver5", "32456"); //not subscribed to shop
		driver1.subscribe("City Shop");
		driver2.subscribe("City Shop");
		driver3.subscribe("City Shop");
		driver4.subscribe("City Shop");
		driver5.subscribe("City Shop");
		
		shop.notify(new DeliveryRequest(shop, "order_1", "delivery address"));
		
		assertTrue(driver1.getNotifications().size() != 0);
		assertEquals(1, driver1.getNotifications().size());	
		assertTrue(driver6.getNotifications().size() == 0);
		assertTrue(CommonDeliveryCart.getPendingDrs().size() != 0);
		assertEquals("order_1", CommonDeliveryCart.pickUpDr().getOrderId());
	}
}
