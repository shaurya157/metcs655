package edu.bu.met.cs665.assignment3;

/**
 * This Frequent Customer is a extended AbstractCustomer,
 * Will contain Frequent customer specific informations and functions.
 */
public class FrequentCustomer extends AbstractCustomer {

	public FrequentCustomer(String name) {
		super(name, CustomerType.FREQUENT);
		setMessager(new FrequentCustomerMessage(name));
	}	
}
