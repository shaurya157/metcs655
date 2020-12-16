package edu.bu.met.cs665.assignment3;

/**
 * This Business Customer is a extended AbstractCustomer,
 * Will contain Business customer specific informations and functions.
 */
public class BusinessCustomer extends AbstractCustomer {

	public BusinessCustomer(String name) {
		super(name, CustomerType.BUSINESS);
		setMessager(new BusinessCustomerMessage(name));
	}
	
}
