public class MaxStockProfit {

    public static void printProfitIndexes(int[] prices) {
        int profitStartIdx = -1;
        int prevPrice = -1;
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                profitStartIdx = i;
            }
            else if (i == prices.length-1) {
                if ((i - profitStartIdx) > 1)
                    System.out.print("("+profitStartIdx+" "+i+")");
            }
            else {
                if (prices[i] < prevPrice) {
                    if ((i - profitStartIdx) > 1)
                        System.out.print("("+profitStartIdx+" "+(i-1)+") ");
                    profitStartIdx = i;
                }
            }
            prevPrice = prices[i];
        }
    }

    public static int getMaxStockProfit(int[] prices) {
        int lowestStockPrice = 0;
        int profit = 0;
        int maxProfit = profit;
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                lowestStockPrice = prices[i];
            }
            else {
                profit = prices[i] - lowestStockPrice;
                if (profit > maxProfit)
                    maxProfit = profit;
                else if (prices[i] < lowestStockPrice)
                    lowestStockPrice = prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        //int[] stockPrices = new int[] {10, 7, 5, 8, 11, 9};
        //System.out.println("Max stock Profit = " + getMaxStockProfit(stockPrices));

        int[] stockPrices1 = { 100, 180, 260, 310, 40, 535, 695};
        int[] stockPrices2 = { 23, 13, 25, 29, 33, 19, 34, 45, 65, 67 };
        printProfitIndexes(stockPrices2);
    }
}
