public class DividendStocks extends Stocks {

    private double dividends; // amount of dividends paid

    public DividendStocks(String symbol, double currentPrice) {
        super(symbol, currentPrice);
        dividends = 0.0;
    }

    @Override
    public double getMarketValue() {
        return super.getMarketValue() + dividends;
    }

    // records a dividend of the given amount per share
    public void payDividend(double amountPerShare){
        dividends += amountPerShare * getTotalShares();
    }
}
