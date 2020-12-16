package edu.bu.met.cs665.assignment3;

public class VipCustomerMessage extends  AbstractMessage {

    public VipCustomerMessage(String customerName) {
        super(customerName);
    }

    @Override
    protected String bodyText(String message) {
        return " Start of 'VIP' customer Message Body\n" +
                "#"+message +"#\n"+
                "=End of VIP customer message body\n";
    }
}
