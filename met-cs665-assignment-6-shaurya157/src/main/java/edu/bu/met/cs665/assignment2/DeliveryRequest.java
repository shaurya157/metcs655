package edu.bu.met.cs665.assignment2;

/**
 * DeliveryRequest is a event object. A shop can notify to its drivers for a delivery request.
 *
 */
public class DeliveryRequest {

	/**
	 * Constructor for delivery request. 
	 * @param shop
	 * @param orderId
	 * @param deliveryAddress
	 */
	public DeliveryRequest(Shop shop, String orderId, String deliveryAddress) {
		this.shop = shop;
		this.orderId = orderId;
		this.deliveryAddress = deliveryAddress;
	}
	
	private Shop shop;
	private String orderId;
	private String deliveryAddress;
	
	public Shop getShop() {
		return shop;
	}

	public String getOrderId() {
		return orderId;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}
}
