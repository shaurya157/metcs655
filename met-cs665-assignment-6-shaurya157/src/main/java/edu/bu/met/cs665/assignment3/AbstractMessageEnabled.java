package edu.bu.met.cs665.assignment3;

/**
 * Abstract Message Enabled with abstract methods which are implemented by inherited classes.
 * Hook methods are included in this template. The methods can be implemented by
 * any of the inherited classes to get customized message header, footer and body.
 * This is a message enabled abstract class.
 * It will be useful in  the future if we are using strategy design pattern.
 * Various message types can be implemented and included anywhere required.
 */
public abstract class AbstractMessageEnabled implements IMessageEnabled {
	
	protected abstract String header() ;
	
	protected abstract String footer();
	
	protected abstract String bodyText(String message);
	
	/**
	 * Public method which gives message text in customer specific format
	 * by passing the information to send.
	 * Three hooks are combined in this method which are provided for
	 * implementing the message format.  
	 */
	@Override
	public String message(String message) {
		StringBuilder sb = new StringBuilder();
		return sb.append(header())
			.append(bodyText(message))
			.append(footer())
			.toString();
	}

}
