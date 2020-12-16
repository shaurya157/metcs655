package edu.bu.met.cs665.assignment3;

public class FrequentCustomerMessage extends  AbstractMessage {

    public FrequentCustomerMessage(String customerName) {
        super(customerName);
    }

    @Override
    protected String bodyText(String message) {
        return " Start of 'Frequent' customer Message Body\n" +
                "#"+message +"#\n"+
                "=End of Frequent customer message body\n";
    }
}
