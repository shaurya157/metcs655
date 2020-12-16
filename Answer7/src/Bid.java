public class Bid {
    public int bidAmount;
    public Product product;
    public Buyer buyer;

    public Bid(int bidAmount, Product product, Buyer buyer) {
        this.bidAmount = bidAmount;
        this.product = product;
        this.buyer = buyer;
    }
}
