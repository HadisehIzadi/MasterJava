public class MutualFunds extends ShareAsset{
    private double totalShares;

    public MutualFunds(String symbol, double currentPrice) {
        super(symbol, currentPrice);
        totalShares = 0.0;
    }


    @Override
    public double getMarketValue() {
        return totalShares * getCurrentPrice();
    }

    public double getTotalShares() {
        return totalShares;
    }


    // records purchase of the given shares at the given price
    public void purchase(double shares, double pricePerShare){
        totalShares += shares;
        addCost(shares* pricePerShare);
    }
}
