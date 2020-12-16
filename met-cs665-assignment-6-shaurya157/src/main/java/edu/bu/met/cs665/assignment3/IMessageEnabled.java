package edu.bu.met.cs665.assignment3;

/**
 * Interface that can be implemented by any message enabled object
 * and the common message() method is available in all descendants.  
 */
public interface IMessageEnabled {
	
	public String message(String message);
}
