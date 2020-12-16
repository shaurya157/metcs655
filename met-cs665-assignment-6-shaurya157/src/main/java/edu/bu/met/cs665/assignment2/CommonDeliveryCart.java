package edu.bu.met.cs665.assignment2;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 
 * Goto place for drivers to pick up the new delivery requests.
 * Shops will be updating the queue and notify drivers.  
 *
 */
public class CommonDeliveryCart {
	
	private static Queue<DeliveryRequest> pendingDrs = new ConcurrentLinkedQueue<DeliveryRequest>();
	
	public static void addToQueue(DeliveryRequest dr) {
		getPendingDrs().add(dr);
	}
	
	/**
	 * Any dirver can pickup the delivery request from the queue
	 * @return
	 */
	public static DeliveryRequest pickUpDr() {
		return getPendingDrs().poll();
	}
	
	public static Queue<DeliveryRequest> getPendingDrs() {
		return pendingDrs;
	}
	
	public static void reset() {
		pendingDrs = new ConcurrentLinkedQueue<>();
	}
}
