public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int profit = 0;
        for (int stock : prices) {
            if (stock < min) {
                min = stock;
            } else if (stock - min > profit) {
                profit = stock - min;
            }
        }
        return profit;
    }
}