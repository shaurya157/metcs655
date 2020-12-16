package edu.bu.met.cs665.assignment3;

public abstract class AbstractMessage extends AbstractMessageEnabled {

    private String customerName;

    public AbstractMessage(String customerName) {
        this.customerName = customerName;
    }

    public String getName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Returns a common header configured for all messages from the company.
     * Can be written in descending child classes for specific customization.
     */
    @Override
    protected String header() {
        return "^HEADER^n"
                + "Hi " +getName() +"!\n\n";
    }

    /**
     * Returns a common footer configured for all messages from the company.
     * Can be written in descending child classes for specific customization.
     */
    @Override
    protected String footer() {
        return "\nWith regards\nTest Company\n\n^FOOTER#FOOTER\n";
    }

    /**
     * Returns a common body configured for all messages from the company.
     * Can be written in descending child classes for specific customization.
     */
    @Override
    protected String bodyText(String message) {
        return 	"Message Body Start\n" +
                message +
                "Message Body End";
    }
}
