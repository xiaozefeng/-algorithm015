package org.mickey.homework.week8;

public class _70_ClimbStairs {
    // 1. Recursion
    // 2. Memorized Recursion
    // 3. Dynamic Programming
    // 4. Fibonacci
    public int recursion(int n) {
        return climb_stairs(0, n);
    }

    private int climb_stairs(int i, int n) {
        if (i >n ) return 0;
        if (i == n) return 1;
        return climb_stairs(i +1, n) + climb_stairs(i+2, n);
    }


    // ---------------------


    public int memorization(int n) {
        int [] mem = new int[n +1];
        return memorization_climb_stairs(0, n, mem);
    }

    private int memorization_climb_stairs(int i, int n, int[] mem) {
        if (i >n) return 0;
        if ( i== n) return 1;
        if (mem[i] ==0)
            mem[i] = memorization_climb_stairs(i + 1, n, mem)
                    + memorization_climb_stairs(i + 2, n, mem);
        return mem[i];
    }

    // ----------------------

    public  int dp(int n){
        if ( n ==1) return 1;
        int [] dp = new int[n +1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <=n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }

    // ---------------------

    public  int fibonacci(int n) {
        if (n ==1) return 1;
        int first = 1;
        int second = 2;
        for (int i = 3; i <=n; i++) {
            int third = first + second;
            first = second;
            second =third;
        }
        return second;
    }
}

