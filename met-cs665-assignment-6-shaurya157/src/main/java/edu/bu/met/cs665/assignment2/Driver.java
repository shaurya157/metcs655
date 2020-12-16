package edu.bu.met.cs665.assignment2;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * Driver class which listens to delivery request.
 * 
 */
public class Driver {

	private static Logger logger = Logger.getLogger(Driver.class);
	
	/**
	 * Driver constructor with name and phone number
	 * @param name
	 * @param phone
	 */
	public Driver(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

	private String name;
	private String phone;
	private DriverStatus status = DriverStatus.AVAILABLE;
	private List<String> notifications = new ArrayList<String>();
	
	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public DriverStatus getStatus() {
		return status;
	}
	
	public void setStatus(DriverStatus status) {
		this.status = status;
	}

	public List<String> getNotifications() {
		return notifications;
	}
	
	private void addNotification(String notification) {
		getNotifications().add(notification);
	}

	/**
	 * Status to indicate drivers availability 
	 */
	public static enum DriverStatus {
		AVAILABLE, NOT_AVAILABLE
	}

	public void subscribe(String chanel) {
		NotificationService.subscribe(chanel, this);
	}
	
	public boolean listen(DeliveryRequest event) {		
		if(this.getStatus().equals(DriverStatus.NOT_AVAILABLE)) {
			 //if driver not available. do something return false;
			return false;
		}
		//action to inform driver goes here
		String notification = notificationString(event);
		addNotification(notification);
		logger.info(notification); // do actions. 
		return true;
	}
	
	private String notificationString(DeliveryRequest event) {
		return new StringBuilder("New delivery request arrived to driver : ")
				.append(this.getName())
				.append(", from shop : ")
				.append(event.getShop().getName())
				.append(", order id : ")
				.append(event.getOrderId())
				.append(", delivery address: ")
				.append(event.getDeliveryAddress())
				.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		
		if(!(obj instanceof Driver)) return false;
		
		Driver o = (Driver) obj;
		
		return this.getName().equals(o.getName());
	}
	@Override
	public int hashCode() {
		return this.getName().hashCode();
	}
}

