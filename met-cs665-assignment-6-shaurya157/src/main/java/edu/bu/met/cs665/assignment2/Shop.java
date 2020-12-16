package edu.bu.met.cs665.assignment2;

/**
 * Shop class which is responsible to send delivery to the drivers.
 * Delivery request is event generated by shop when a order placed successfully. 
 *
 */
public class Shop  {
	
	public Shop (String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	private String name;
	private String address;
	
	
	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}


	/**
	 * Adding delivery request to queue and notify all drivers about new request.
	 * 
	 * @param DeliveryRequest event to notify to drivers. 
	 */
	public void notify(DeliveryRequest event) {
		CommonDeliveryCart.addToQueue(event); 
		NotificationService.addMessage(getName(), event);
		NotificationService.broadcast(getName());
	}
	
}
