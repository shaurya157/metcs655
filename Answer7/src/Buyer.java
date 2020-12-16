import java.util.ArrayList;
import java.util.List;

public class Buyer {
    public List<Product> productsBought;
    public String name;

    public Buyer(String name) {
        this.name = name;
        productsBought = new ArrayList<Product>();
    }

    public void addProduct(Product product) {
        productsBought.add(product);
    }

    public List<Product> getProductsBought() {
        return productsBought;
    }

    public void getNotification(Bid bid){
        System.out.println("Notification for " + bid.product.name +
                ", sold by " + bid.product.seller.name +
                " has a new bid of " + bid.bidAmount +
                " by " + bid.buyer.name);
    }
}
