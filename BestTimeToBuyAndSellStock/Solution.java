/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Runtime: 424 ms (too slow!!)
 */
public class Solution {
    int lastLeastPos = 0;

    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int maxProfit = 0;
        int max = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > max && i != prices.length - 1) {
                max = prices[i];
            } else {
                int profit = 0;
                if (prices[i] > max && i == prices.length - 1) {
                    profit = profitIfLastPosIs(i, prices);
                } else {
                    profit = profitIfLastPosIs(i - 1, prices);
                }
                if (profit > maxProfit) maxProfit = profit;
                max = prices[i];
            }
        }
        return maxProfit;
    }

    public int profitIfLastPosIs(int pos, int[] prices) {
        for (int i = lastLeastPos; i < pos; i++) {
            if (prices[i] < prices[lastLeastPos]) {
                lastLeastPos = i;
            }
        }
        return prices[pos] - prices[lastLeastPos];
    }
}
