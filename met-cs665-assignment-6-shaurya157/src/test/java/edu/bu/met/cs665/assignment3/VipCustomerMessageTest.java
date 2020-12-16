package edu.bu.met.cs665.assignment3;

import org.apache.log4j.Logger;
import org.junit.Test;

public class VipCustomerMessageTest {

	Logger log = Logger.getLogger(VipCustomerMessageTest.class);

	@Test
	public void testCustomer() {
		AbstractMessage customer = new VipCustomerMessage("Simple customer");
		log.info(customer.message("This is message to basic customer"));
	}
}
