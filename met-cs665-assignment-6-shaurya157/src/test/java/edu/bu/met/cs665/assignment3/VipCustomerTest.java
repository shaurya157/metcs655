package edu.bu.met.cs665.assignment3;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Test;

import edu.bu.met.cs665.assignment3.AbstractCustomer.CustomerType;

public class VipCustomerTest {
	
	Logger log = Logger.getLogger(VipCustomerTest.class);

	@Test
	public void testReturnCustomerTest() {
		VipCustomer customer = new VipCustomer("VIP customer");
		assertEquals("VIP customer", customer.getName());
		assertEquals(CustomerType.VIP, customer.getType());
		log.info("Mail body starts here for VIP customer\n");
		log.info(customer.getMessage("This is message to VIP customer"));
		log.info("Mail body ends here for VIP customer\n");
	}
}
