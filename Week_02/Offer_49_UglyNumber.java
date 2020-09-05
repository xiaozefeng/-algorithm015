package org.mickey.homework.week2;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author mickey
 * @date 9/5/20 21:41
 */
public class Offer_49_UglyNumber {
    // 暴力解法， 不过通不过
    public int nthUglyNumberBruteForce(int n) {
        if (n == 1) return 1;
        int count = 1;
        int i;
        for (i = 2; count < n; i++) {
            if (isUglyNumber(i)) {
                count++;
            }
        }
        return i - 1;
    }

    private boolean isUglyNumber(int number) {
        for (int i = 2; i < 6 && number > 0; i++)
            while (number % i == 0)
                number /= i;

        return number == 1;
    }


    // 使用堆， 不过超出时间限制了
    public int nthUglyNumberUsingHeap(int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 1; pq.size() < n; i++) {
            if (isUglyNumber(i))
                pq.add(i);
        }
        return pq.poll();
    }


    // 动态规划 , 不懂， 先抄下来
    public int nthUglyNumber(int n) {
        int p2 = 0, p3 = 0, p5 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
            if (dp[i] == dp[p2] * 2) p2++;
            if (dp[i] == dp[p3] * 3) p3++;
            if (dp[i] == dp[p5] * 5) p5++;
        }
        return dp[n - 1];
    }
}
