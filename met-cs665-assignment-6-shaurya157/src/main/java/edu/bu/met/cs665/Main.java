package edu.bu.met.cs665;

import org.apache.log4j.Logger;

import edu.bu.met.cs665.assignment2.DeliveryRequest;
import edu.bu.met.cs665.assignment2.Driver;
import edu.bu.met.cs665.assignment2.Shop;
import edu.bu.met.cs665.assignment3.AbstractCustomer;
import edu.bu.met.cs665.assignment3.CustomerFactory;
import edu.bu.met.cs665.assignment3.AbstractCustomer.CustomerType;

public class Main {

  private static Logger log = Logger.getLogger(Main.class);


  /**
   * A main method to run examples.
   *
   * @param args not used
   */
  public static void main(String[] args) {
	  log.info("Starting application........");
	  assignment2();
	  assignment3();
	  log.info("Terminating application.....");
  }

  private static void assignment2() {
	  Shop shop = new Shop("City Shop", "address");
		Driver driver1 = new Driver("driver1", "12345");
		Driver driver2 = new Driver("driver2", "98765");
		Driver driver3 = new Driver("driver3", "43556");
		Driver driver4 = new Driver("driver4", "3786");
		Driver driver5 = new Driver("driver5", "32456");
		driver1.subscribe("City Shop");
		driver2.subscribe("City Shop");
		driver3.subscribe("City Shop");
		driver4.subscribe("City Shop");
		driver5.subscribe("City Shop");
		
		shop.notify(new DeliveryRequest(shop, "order_1", "delivery address"));
  }
  private static void assignment3() {
	generateCustomerNotification(CustomerType.BASIC);
	  generateCustomerNotification(CustomerType.BUSINESS);
	  generateCustomerNotification(CustomerType.FREQUENT);
	  generateCustomerNotification(CustomerType.RETURNING);
	  generateCustomerNotification(CustomerType.NEW);
	  generateCustomerNotification(CustomerType.VIP);
}

  public static void generateCustomerNotification(CustomerType type) { // making public to JUnit test
	  log.info("Generating Notification for " + type + " customer \n");
	  AbstractCustomer business = CustomerFactory.createCustomer(type, type+"_CUSTOMER");
	  log.info(business.getMessage("Test text message for " +type+" customer"));
	  log.info("End of notification for "+type +" customer\n");
  }
}
