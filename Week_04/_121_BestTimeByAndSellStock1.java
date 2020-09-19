package org.mickey.homework.week4;

/**
 * @author mickey
 * @date 2020/9/15 16:09
 */
public class _121_BestTimeByAndSellStock1 {

    // 暴力解法
    public int bruteForce(int[] prices) {
        int ans = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > ans)
                    ans = profit;
            }
        }
        return ans;
    }


    public int onePass(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    // Kadane's Algorithm
    public int maxProfit(int[] prices) {
        int maxCur = 0;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur + (prices[i] - prices[i - 1]));
            maxProfit = Math.max(maxCur, maxProfit);
        }
        return maxProfit;
    }


}
