package edu.bu.met.cs665.assignment3;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Test;

import edu.bu.met.cs665.assignment3.AbstractCustomer.CustomerType;

public class FrequentCustomerTest {

	Logger log = Logger.getLogger(FrequentCustomerTest.class);
	
	@Test
	public void testCustomer() {
		FrequentCustomer customer = new FrequentCustomer("Frequent customer");
		assertEquals("Frequent customer", customer.getName());
		assertEquals(CustomerType.FREQUENT, customer.getType());
		log.info("Mail body starts here for Frequent customer\n");
		log.info(customer.getMessage("This is message to Frequent customer"));
		log.info("Mail body ends here for Frequent customer\n");
	}
}
