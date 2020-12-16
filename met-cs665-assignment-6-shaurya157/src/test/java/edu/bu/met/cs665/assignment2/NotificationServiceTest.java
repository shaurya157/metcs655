package edu.bu.met.cs665.assignment2;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class NotificationServiceTest {


	@BeforeClass
	public static void init() {
		NotificationService.reset();
		CommonDeliveryCart.reset();
	}

	@Test
	public void testSubscribe() {
		Driver driver1 = new Driver("driver1", "12345");
		driver1.subscribe("City Shop");
		assertEquals(1, NotificationService.getListeners("City Shop").size());
	}
	
	@Test
	public void testUnsubscribe() {
		Driver driver1 = new Driver("driver1", "12345");
		driver1.subscribe("City Shop");
		assertEquals(1, NotificationService.getListeners("City Shop").size());
		NotificationService.unsubscribe("City Shop", driver1);
		assertEquals(0, NotificationService.getListeners("City Shop").size());
	}
	
	@Test
	public void testAddMessage() {
		Shop shop = new Shop("City Shop", "address");
		Driver driver1 = new Driver("driver1", "12345");
		driver1.subscribe("City Shop");
		NotificationService.broadcast("City Shop");
		NotificationService.addMessage("City Shop", new DeliveryRequest(shop, "1", "Address"));
		assertEquals(1, NotificationService.getPendingMessages("City Shop").size());
	}
	
	@Test
	public void testBroadcast() {
		Shop shop = new Shop("City Shop", "address");
		Driver driver1 = new Driver("driver1", "12345");
		driver1.subscribe("City Shop");
		NotificationService.addMessage("City Shop", new DeliveryRequest(shop, "1", "Address"));
		NotificationService.broadcast("City Shop");
		assertEquals(0, NotificationService.getPendingMessages("City Shop").size());
	}
}
