package edu.bu.met.cs665.assignment3;

public class CustomerMessage extends  AbstractMessage {

    public CustomerMessage(String customerName) {
        super(customerName);
    }
    
    @Override
    protected String bodyText(String message) {
        return " Start of customer Message Body\n" +
                "#"+message +"#\n"+
                "=End of customer message body\n";
    }
}
