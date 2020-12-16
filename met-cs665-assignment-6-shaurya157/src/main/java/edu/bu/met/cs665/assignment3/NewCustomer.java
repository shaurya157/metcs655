package edu.bu.met.cs665.assignment3;

/**
 * This NEW Customer is a extended AbstractCustomer,
 * Will contain NEW customer specific informations and functions.
 */
public class NewCustomer extends AbstractCustomer {

	public NewCustomer(String name) {
		super(name, CustomerType.NEW);
		setMessager(new NewCustomerMessage(name));
	}	
}
