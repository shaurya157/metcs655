import java.util.ArrayList;
import java.util.List;

public class AuctionSystem {
    public List<Product> productList = new ArrayList<Product>();
    public List<Buyer> buyerList = new ArrayList<Buyer>();

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void addBuyer(Buyer buyer) {
        buyerList.add(buyer);
    }

    public void addBid(Product product, int amount, Buyer buyer) {
        Bid bid = new Bid(amount, product, buyer);
        Boolean added = product.addBid(bid);

        if(added) {
            notifyAllBuyers(bid);
        }
    }

    private void notifyAllBuyers(Bid bid){
        for(Buyer buyer : buyerList) {
            buyer.getNotification(bid);
        }
    }
}
