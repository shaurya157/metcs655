package edu.bu.met.cs665.assignment3;

public class ReturningCustomerMessage extends  AbstractMessage {

    public ReturningCustomerMessage(String customerName) {
        super(customerName);
    }
    
    @Override
    protected String bodyText(String message) {
        return " Start of 'Returning' customer Message Body\n" +
                "#"+message +"#\n"+
                "=End of Returning customer message body\n";
    }
}
