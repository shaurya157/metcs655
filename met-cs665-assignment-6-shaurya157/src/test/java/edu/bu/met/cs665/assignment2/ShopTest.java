package edu.bu.met.cs665.assignment2;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

public class ShopTest {


	@BeforeClass
	public static void init() {
		NotificationService.reset();
		CommonDeliveryCart.reset();
	}

	@Test
	public void testShop() {
		Shop shop = new Shop("City Shop", "address");
		assertEquals("City Shop", shop.getName());
		assertEquals("address", shop.getAddress());
	}
	
	@Test
	public void testShopNotify() {
		Shop shop = new Shop("City Shop", "address");
		shop.notify(new DeliveryRequest(shop, "1", "Address"));
		assertEquals(1, CommonDeliveryCart.getPendingDrs().size());
	}
}
