/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Runtime: 218 ms (too slow!!)
 *
 * ˼·������prices���飬�����м�¼����͵�price��Ȼ��ÿһ�������յ㣨ǰһ��ߺ�һ��ͣ��������һ�죩��ʱ�򣬾������price����͵�price����һ��profit�����profit��֮ǰ�Ĵ󣬾��滻֮ǰ�ģ����ó������
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
