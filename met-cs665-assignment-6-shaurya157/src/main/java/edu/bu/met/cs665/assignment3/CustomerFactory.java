package edu.bu.met.cs665.assignment3;

import edu.bu.met.cs665.assignment3.AbstractCustomer.CustomerType;

public class CustomerFactory {

	public static AbstractCustomer createCustomer(CustomerType type, String name)  {
		if(type == null) {
			return new Customer(name);
		}
		switch (type) {
			case BUSINESS : 
				return  new BusinessCustomer(name);
			case RETURNING :  
				return new ReturningCustomer(name);
			case FREQUENT : 
				return new FrequentCustomer(name);
			case NEW : 
				return new NewCustomer(name);
			case VIP : 
				return new VipCustomer(name);
			default : 
				return new Customer(name);
		}
	}
}
