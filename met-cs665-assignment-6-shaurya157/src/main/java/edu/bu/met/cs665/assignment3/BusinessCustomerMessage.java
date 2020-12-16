package edu.bu.met.cs665.assignment3;

public class BusinessCustomerMessage  extends  AbstractMessage {

    public BusinessCustomerMessage(String customerName) {
        super(customerName);
    }

    @Override
    protected String bodyText(String message) {
        return " Start of 'BUSINESS' customer Message Body\n" +
                "#"+message +"#\n"+
                "=End of BUSINESS customer message body\n";
    }
}
