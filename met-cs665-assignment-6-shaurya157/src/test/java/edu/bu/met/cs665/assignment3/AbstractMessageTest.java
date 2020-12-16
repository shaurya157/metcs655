package edu.bu.met.cs665.assignment3;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Test;

public class AbstractMessageTest {

	Logger log = Logger.getLogger(AbstractMessageTest.class);

	@Test
	public void testCustomer() {
		AbstractMessage customer = new CustomerMessage("Simple customer");
		
		assertEquals("Simple customer", customer.getName());
		log.info(customer.message("This is message to basic customer"));
		log.info("Mail body ends here for Basic customer\\n");
	}
}
