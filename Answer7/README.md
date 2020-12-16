

# Implementation Description

The project implements the observer design pattern. This is a simple implementation where the AuctionSystem sends a notification to all buyers
when a new bid is placed. Normally, I would have used a listener abstract class as well as a notification class, however since I had a time limit
and there were no instructions as to how complicated this implementation needs to be, I have used a simple method declaration as a way
to notify the buyers.

Every time a new Bid is created for an associated product, it is added to the AuctionSystem, which then sees if the new bid is bigger than the old one.
After addition, it then notifiyAllBuyer() by calling the buyer.getNotification() method. This should ideally be listeners attached to the buyer
and the shop just calls the Listener.

I have created multiple products, buyers and sellers to conduct rudimentary testing. This can be run by running main.java.
