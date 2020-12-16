package edu.bu.met.cs665.assignment2;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class DeliveryRequestTest {
	
	@BeforeClass
	public static void init() {
		NotificationService.reset();
		CommonDeliveryCart.reset();
	}

	@Test
	public void testDeliveryRequest() {
		Shop shop = new Shop("City Shop", "address");
		DeliveryRequest dr = new DeliveryRequest(shop, "order_1", "delivery address");
		assertEquals(shop, dr.getShop());
		assertEquals("delivery address", dr.getDeliveryAddress());
		assertEquals("order_1", dr.getOrderId());
	}
	
	@Test
	public void testDeliveryCart() {
		Shop shop = new Shop("City Shop", "address");
		DeliveryRequest dr = new DeliveryRequest(shop, "order_1", "delivery address");
		CommonDeliveryCart.addToQueue(dr);
		assertEquals(1, CommonDeliveryCart.getPendingDrs().size());
		CommonDeliveryCart.pickUpDr();
		assertEquals(0, CommonDeliveryCart.getPendingDrs().size());
	}
}
