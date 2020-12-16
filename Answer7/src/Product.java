import java.util.ArrayList;
import java.util.List;

public class Product {
    public String name;
    public Seller seller;
    public List<Bid> bids = new ArrayList<Bid>();

    public Product(String name, Seller seller) {
        this.name = name;
        this.seller = seller;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public Boolean addBid(Bid bid) {
        if (bids.size() == 0 || bids.get(bids.size() - 1).bidAmount < bid.bidAmount) {
            bids.add(bid);
            return true;
        }

        return false;
    }

}
