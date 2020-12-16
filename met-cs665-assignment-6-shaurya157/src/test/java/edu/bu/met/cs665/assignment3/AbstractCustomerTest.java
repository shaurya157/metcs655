package edu.bu.met.cs665.assignment3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.Test;

import edu.bu.met.cs665.Main;
import edu.bu.met.cs665.assignment3.AbstractCustomer.CustomerType;

public class AbstractCustomerTest {

	Logger log = Logger.getLogger(AbstractCustomerTest.class);
	
	@Test
	public void testCustomer() {
		AbstractCustomer customer = new Customer("Simple customer");
		
		assertEquals("Simple customer", customer.getName());
		assertEquals(CustomerType.BASIC, customer.getType());
		assertTrue(customer.getCustomerId() > 0);
		log.info("Mail body starts here for Basic customer\n");
		log.info(customer.getMessage("This is message to basic customer"));
		log.info("Mail body ends here for Basic customer\\n");
	}
	
	@Test
	public void testFactory() {
		AbstractCustomer customer = CustomerFactory.createCustomer(CustomerType.BASIC, "customer");
		AbstractCustomer businessCustomer = CustomerFactory.createCustomer(CustomerType.BUSINESS, "businessCustomer");
		AbstractCustomer frequentCustomer = CustomerFactory.createCustomer(CustomerType.FREQUENT, "frequentCustomer");
		AbstractCustomer returningCustomer = CustomerFactory.createCustomer(CustomerType.RETURNING, "returningCustomer");
		AbstractCustomer vipCustomer = CustomerFactory.createCustomer(CustomerType.VIP, "vipCustomer");
		AbstractCustomer newCustomer = CustomerFactory.createCustomer(CustomerType.NEW, "newCustomer");
		AbstractCustomer basicCustomer = CustomerFactory.createCustomer(null, "basicCustomer");


		assertEquals("customer", customer.getName());
		assertEquals("businessCustomer", businessCustomer.getName());
		assertEquals("frequentCustomer", frequentCustomer.getName());
		assertEquals("returningCustomer", returningCustomer.getName());
		assertEquals("vipCustomer", vipCustomer.getName());
		assertEquals("newCustomer", newCustomer.getName());
		assertEquals("basicCustomer", basicCustomer.getName());
		
		assertEquals(CustomerType.BASIC, customer.getType());
		assertEquals(CustomerType.BUSINESS, businessCustomer.getType());
		assertEquals(CustomerType.FREQUENT, frequentCustomer.getType());
		assertEquals(CustomerType.RETURNING, returningCustomer.getType());
		assertEquals(CustomerType.VIP, vipCustomer.getType());
		assertEquals(CustomerType.NEW, newCustomer.getType());
		assertEquals(CustomerType.BASIC, basicCustomer.getType());
	}
	
	@Test
	public void testGenerateCustomerNotification() {
		Main.generateCustomerNotification(CustomerType.BASIC);
	}
}
