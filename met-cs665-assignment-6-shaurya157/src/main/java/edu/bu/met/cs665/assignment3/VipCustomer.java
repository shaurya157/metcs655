package edu.bu.met.cs665.assignment3;

/**
 * This VIP Customer is a extended AbstractCustomer,
 * Will contain VIP customer specific informations and functions
 *
 */
public class VipCustomer extends AbstractCustomer {
	
	public VipCustomer(String name) {
		super(name, CustomerType.VIP);
		setMessager(new VipCustomerMessage(name));
	}	
}
