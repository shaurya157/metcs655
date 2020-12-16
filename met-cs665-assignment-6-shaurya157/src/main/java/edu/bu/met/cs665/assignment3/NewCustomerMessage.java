package edu.bu.met.cs665.assignment3;

public class NewCustomerMessage extends  AbstractMessage {

    public NewCustomerMessage(String customerName) {
        super(customerName);
    }

    @Override
    protected String bodyText(String message) {
        return " Start of 'New' customer Message Body\n" +
                "#"+message +"#\n"+
                "=End of New customer message body\n";
    }
}
