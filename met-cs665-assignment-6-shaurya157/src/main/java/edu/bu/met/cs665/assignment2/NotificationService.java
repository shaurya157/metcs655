package edu.bu.met.cs665.assignment2;

import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * A centralized message broker in Pub Sub architecture. 
 * Shops will place the delivery request in respective channel queue. 
 * 
 * The messages will asynchronously sent to the drivers who subscribed to shop channels.
 *
 */
public class NotificationService  {

	private static Map<String, Queue<DeliveryRequest>> events = new ConcurrentHashMap<>();
	private static Map<String, Set<Driver>> listners = new ConcurrentHashMap<>();;
	
	public static void subscribe(String channel,  Driver listner) {
		Set<Driver> list;
		if(!listners.containsKey(channel)) {
			list = new HashSet<>();
		} else {
			list = listners.get(channel);
		}
		list.add(listner);
		listners.put(channel, list);
	}
	
	public static void unsubscribe(String channel,  Driver listner) {
		Set<Driver> list;
		if(!listners.containsKey(channel)) {
			return;
		} else {
			list = listners.get(channel);
		}
		list.remove(listner);
		listners.put(channel, list);
	}
	
	public static  void addMessage(String channel, DeliveryRequest event) {
		Queue<DeliveryRequest> eventList;
		if(!events.containsKey(channel)) {
			eventList = new ConcurrentLinkedQueue<>();
		} else {
			eventList = events.get(channel);
		}
		eventList.add(event);
		events.put(channel, eventList);
	}
	
	public static  void broadcast(String channel) {
		Queue<DeliveryRequest> eventList;
		if(!events.containsKey(channel)) {
			//log no message available
			return;
		}else {
			eventList = events.get(channel);
		}
		
		Set<Driver> list;
		if(!listners.containsKey(channel)) {
			// no listeners
			return;
		} else {
			list = listners.get(channel);
		}
		while(!eventList.isEmpty()) {
			publish(list, eventList.poll());
		}
	}	

	private static  void publish(Set<Driver> list, DeliveryRequest e) {
		list.forEach(l -> publish(l, e));
	}
	
	private static void publish(Driver l, DeliveryRequest e) {
		l.listen(e);
	}	
	
	public static Set<Driver> getListeners(String channel) {
		return listners.get(channel);
	}
	
	public static Queue<DeliveryRequest> getPendingMessages(String channel) {
		return events.get(channel);
	}
	
	public static void reset() {
		events = new ConcurrentHashMap<>();
		listners = new ConcurrentHashMap<>();
	}
}
