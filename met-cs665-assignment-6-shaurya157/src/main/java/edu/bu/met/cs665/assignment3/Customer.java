package edu.bu.met.cs665.assignment3;

public class Customer extends AbstractCustomer {

	public Customer(String name) {
		super(name, CustomerType.BASIC);
		setMessager(new CustomerMessage(name));
	}
}
