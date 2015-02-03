/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
 * However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *
 * Runtime: 219 ms
 *
 * 思路：通过手工尝试1~6个数字组成的数组，发现只要今天比明天价格低，就今天买进明天卖出就能获得最大收益
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i-1] < prices[i]) {
                maxProfit += prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }
}
