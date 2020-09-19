package org.mickey.homework.week4;

/**
 * @author mickey
 * @date 2020/9/17 11:46
 */
public class _70_ClimbingStairs {

    // 1. brute force
    public int bruteForce(int n) {
        return climbing_stairs(0, n);
    }

    private int climbing_stairs(int i, int n) {
        if (i > n) return 0;
        if (i == n) return 1;

        return climbing_stairs(i + 1, n) + climbing_stairs(i + 2, n);
    }


    // 2. memorize recursion
    public int memorize(int n) {
        int[] memory = new int[n + 1];
        return memorize_climbing_stairs(0, n, memory);
    }

    private int memorize_climbing_stairs(int i, int n, int[] memory) {
        if (i > n) return 0;
        if (i == n) return 1;
        if (memory[i] > 0) return memory[i];
        memory[i] = memorize_climbing_stairs(i + 1, n, memory) +
                memorize_climbing_stairs(i + 2, n, memory);
        return memory[i];
    }
}
