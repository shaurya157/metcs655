package edu.bu.met.cs665.assignment2;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import edu.bu.met.cs665.assignment2.Driver.DriverStatus;

public class DriverTest {


	@BeforeClass
	public static void init() {
		NotificationService.reset();
		CommonDeliveryCart.reset();
	}

	
	@Test
	public void testDriver() {
		Driver driver1 = new Driver("driver1", "12345");
		assertEquals("driver1", driver1.getName());
		assertEquals("12345", driver1.getPhone());
	}
	
	@Test
	public void testSubscribe() {
		Driver driver1 = new Driver("driver1", "12345");
		driver1.subscribe("City shop");
		assertEquals(1, NotificationService.getListeners("City shop").size());
	}
	
	@Test
	public void testListen() {
		Driver driver1 = new Driver("driver1", "12345");
		Shop shop = new Shop("City Shop", "address");
		driver1.listen(new DeliveryRequest(shop, "1", "Address"));
		assertEquals(1, driver1.getNotifications().size());
	}
	
	@Test
	public void testListenNotAvailble() {
		Driver driver1 = new Driver("driver1", "12345");
		driver1.setStatus(DriverStatus.NOT_AVAILABLE);
		Shop shop = new Shop("City Shop", "address");
		driver1.listen(new DeliveryRequest(shop, "1", "Address"));
		assertEquals(0, driver1.getNotifications().size());
	}
}
