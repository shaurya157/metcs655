package edu.bu.met.cs665.assignment3;

/**
 * A customer object which has a message enabled object.
 * The message enabled object can be injected in run time.
 */
public abstract class AbstractCustomer {
	
	public AbstractCustomer(String name, CustomerType type) {
		this.name = name;
		this.type = type;
	}

	private IMessageEnabled messenger;

	private long customerId = System.currentTimeMillis();
	private String name;
	private CustomerType type;
	//Common customer properties will be added here Ex: Email, Phone, Address etc. 

	/**
	 * Dependent messenger can be injected with this methods.
	 * @param messanger
	 */
	public void setMessager(IMessageEnabled messenger) {
		this.messenger = messenger;
	}

	public long getCustomerId() {
		return customerId;
	}

	public String getName() {
		return name;
	}

	public CustomerType getType() {
		return type;
	}
	public IMessageEnabled getMessenger() {
		return messenger;
	}

	public String getMessage(String message) {
		if(messenger != null) {
			return messenger.message(message);
		}
		return "";
	}
	
	public static enum CustomerType {
		BASIC, BUSINESS, RETURNING, FREQUENT, NEW, VIP;
	}
}
