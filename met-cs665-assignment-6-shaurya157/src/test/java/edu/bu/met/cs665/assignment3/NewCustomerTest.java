package edu.bu.met.cs665.assignment3;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Test;

import edu.bu.met.cs665.assignment3.AbstractCustomer.CustomerType;

public class NewCustomerTest {

	Logger log = Logger.getLogger(NewCustomerTest.class);
	
	@Test
	public void testCustomer() {
		NewCustomer customer = new NewCustomer("New customer");
		assertEquals("New customer", customer.getName());
		assertEquals(CustomerType.NEW, customer.getType());
		log.info("Mail body starts here for New customer\n");
		log.info(customer.getMessage("This is message to New customer"));
		log.info("Mail body ends here for New customer\n");
	}
}
