package edu.bu.met.cs665.assignment3;

/**
 * This Returning Customer is a extended AbstractCustomer,
 * Will contain Returning customer specific informations and functions.
 */
public class ReturningCustomer extends AbstractCustomer {

	public ReturningCustomer(String name) {
		super(name, CustomerType.RETURNING);
	}	
}
