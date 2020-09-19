package org.mickey.homework.week4;

/**
 * @author mickey
 * @date 2020/9/15 16:09
 */
public class _122_BestTimeByAndSellStock2 {


    public  int peak_valley(int [] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];

        int maxProfit = 0;
        while (i < prices.length - 1) {
            while (i <prices.length-1 && prices[i] >= prices[i+1])
                i++;
            valley = prices[i];
            while (i <prices.length-1&&prices[i] <= prices[i+1])
                i++;
            peak = prices[i];
            maxProfit += peak - valley;
        }
        return maxProfit;
    }


    public int maxProfit(int [] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1])
                maxProfit += prices[i] - prices[i - 1];
        }
        return maxProfit;
    }

}
