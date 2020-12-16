package edu.bu.met.cs665.assignment3;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Test;

import edu.bu.met.cs665.assignment3.AbstractCustomer.CustomerType;

public class BusinessCustomerTest {

	Logger log = Logger.getLogger(BusinessCustomerTest.class);
	
	@Test
	public void testCustomer() {
		BusinessCustomer customer = new BusinessCustomer("Business customer");
		assertEquals("Business customer", customer.getName());
		assertEquals(CustomerType.BUSINESS, customer.getType());
		log.info("Mail body starts here for Business customer\n");
		log.info(customer.getMessage("This is message to business customer"));
		log.info("Mail body ends here for Business customer\n");
	}
}
