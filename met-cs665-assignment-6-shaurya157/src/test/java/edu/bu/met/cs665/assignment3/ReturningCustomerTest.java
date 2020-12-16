package edu.bu.met.cs665.assignment3;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Test;

import edu.bu.met.cs665.assignment3.AbstractCustomer.CustomerType;

public class ReturningCustomerTest {
	
	Logger log = Logger.getLogger(ReturningCustomerTest.class);
	
	@Test
	public void testReturnCustomerTest() {
		ReturningCustomer customer = new ReturningCustomer("returning customer");
		assertEquals("returning customer", customer.getName());
		assertEquals(CustomerType.RETURNING, customer.getType());
		log.info("Mail body starts here for returning customer\n");
		log.info(customer.getMessage("This is message to Returning customer"));
		log.info("Mail body ends here for Returning customer\n");	}
}
