public class Main {
    public static void main(String[] args) {
        Seller seller1 = new Seller("Shaurya");
        Seller seller2 = new Seller("Sinha");
        Buyer buyer1 =  new Buyer("John");
        Buyer buyer2 = new Buyer("Jane");
        Buyer buyer3 = new Buyer("Jim");
        AuctionSystem auctionSystem = new AuctionSystem();
        Product product1 = new Product("Chair", seller1);
        Product product2 = new Product("Bed", seller1);
        Product product3 = new Product("House", seller2);

        auctionSystem.addBuyer(buyer1);
        auctionSystem.addBuyer(buyer2);
        auctionSystem.addBuyer(buyer3);
        auctionSystem.addProduct(product1);
        auctionSystem.addProduct(product2);
        auctionSystem.addProduct(product3);

        auctionSystem.addBid(product1, 50, buyer1);
        auctionSystem.addBid(product1, 25, buyer2);
        auctionSystem.addBid(product1, 70, buyer3);
        auctionSystem.addBid(product2, 2, buyer3);
        auctionSystem.addBid(product2, 10, buyer2);
        auctionSystem.addBid(product2, 11, buyer1);

    }
}
