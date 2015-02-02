/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Runtime: 218 ms (too slow!!)
 *
 * 思路：迭代prices数组，过程中记录下最低的price，然后每一次遇到拐点（前一天高后一天低，或者最后一天）的时候，就拿这个price和最低的price计算一个profit，如果profit比之前的大，就替换之前的，最后得出结果。
 */
public class Solution {
    int lastLeastPos = 0;

    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int maxProfit = 0;
        int last = prices[0];
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < last || i == prices.length - 1) {
                int profit = 0;
                if (prices[i] > last && i == prices.length - 1) {
                    profit = prices[i] - min;
                } else {
                    profit = prices[i - 1] - min;
                }
                if (profit > maxProfit) maxProfit = profit;
            }
            last = prices[i];
            if (prices[i] < min) min = prices[i];
        }
        return maxProfit;
    }
}
