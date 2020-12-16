package edu.bu.met.cs665.assignment3;

import org.apache.log4j.Logger;
import org.junit.Test;

public class ReturningCustomerMessageTest {

	Logger log = Logger.getLogger(ReturningCustomerMessageTest.class);

	@Test
	public void testCustomer() {
		AbstractMessage customer = new ReturningCustomerMessage("Simple customer");
		log.info(customer.message("This is message to basic customer"));
	}
}
