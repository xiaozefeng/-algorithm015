package org.mickey.homework.week1;

/**
 * @author mickey
 * @date 8/29/20 13:02
 */
public class _70_ClimbingStairs {

    /**
     * recursion
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * memorize recursion
     *
     * @param n
     * @return
     */
    public int climbStairsMemorize(int n) {
        int[] memorize = new int[n + 1];
        return climbStairsMemorize_0(n, memorize);
    }

    private int climbStairsMemorize_0(int n, int[] memorize) {
        if (memorize[n] > 0) {
            return memorize[n];
        }
        if (n == 1) {
            memorize[n] = 1;
        } else if (n == 2) {
            memorize[n] = 2;
        } else {
            memorize[n] = climbStairsMemorize_0(n - 1, memorize) + climbStairsMemorize_0(n - 2, memorize);
        }
        return memorize[n];
    }


    // fibonacci
    private int climbStairsOnFibonacci(int n) {
        if (n == 1) return 1;
        int first = 1;
        int second = 2;
        int third;
        for (int i = 3; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return second;
    }


}
