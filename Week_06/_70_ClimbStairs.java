package org.mickey.homework.week6;

/**
 * 1. brute force
 * 2. memorize recursion
 * 3. dynamic programming  F(n) = F(n-1) + F(n-2)
 * 4. Fibonacci
 *
 * @author mickey
 * @date 2020/10/1 12:25
 */
public class _70_ClimbStairs {


    // 1. brute force
    public int bruteForce(int n) {
        return _climb_stairs(0, n);
    }

    private int _climb_stairs(int i, int n) {
        if (i > n) return 0;
        if (n == 1) return 1;
        return _climb_stairs(i + 1, n) + _climb_stairs(i + 2, n);
    }


    // 2. memorize recursion
    public int memorization(int n) {
        int[] memory = new int[n + 1];
        return __climb_stairs(0, n, memory);
    }

    private int __climb_stairs(int i, int n, int[] memory) {
        if (i > n) return 0;
        if (n == 1) return 1;
        if (memory[i] > 0) return memory[i];

        memory[i] = __climb_stairs(i + 1, n, memory) + __climb_stairs(i + 2, n, memory);
        return memory[i];
    }


    // 3. dynamic programming
    public int dynamicPrograming(int n){
        if ( n== 1) return 1;
        int[] dp = new int[n +1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <=n ; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        return dp[n];
    }

    // 4. Fibonacci
    public int climbStairs(int n) {
        if (n ==1) return 1;
        int f1 = 1;
        int f2 = 2;
        for (int i = 3; i <= n; i++) {
            int f3 = f2 + f1;
            f1 = f2;
            f2 = f3;
        }
        return f2;
    }

}
