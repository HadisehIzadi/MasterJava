public class Stocks extends ShareAsset{

    private int totalShares;

    public Stocks(String symbol, double currentPrice) {
        super(symbol, currentPrice);
        totalShares =0;
    }


    @Override
    public double getMarketValue() {
        return totalShares*getCurrentPrice();
    }


    public int getTotalShares() {
        return totalShares;
    }


    // Records a purchase of the given number of shares of the
    // stock at the given price per share
    public void purchase(int shares , double pricePerShare){
        totalShares += shares;
        addCost(shares * pricePerShare);
    }


}
