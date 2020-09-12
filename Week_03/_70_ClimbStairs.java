package org.mickey.homework.week3;

/**
 * @author mickey
 * @date 2020/9/11 14:56
 */
public class _70_ClimbStairs {

    // Recursion
    public int climbStairs(int n) {
        return climb_stairs(0, n);
    }

    private int climb_stairs(int i, int n) {
        // terminator
        if (i > n) return 0;
        if (i == n) return 1;


        // process

        // drill down
        return climb_stairs(i + 1, n) + climb_stairs(i + 2, n);

        // reverse state
    }


    // use extra space
    public int recursion_memorization(int n) {
        int[] memory = new int[n + 1];
        return climb_stairs_memory(0, n, memory);
    }

    private int climb_stairs_memory(int i, int n, int[] memory) {
        // terminator
        if (i > n) return 0;
        if (i == n) return 1;

        // process
        if (memory[i] > 0) {
            return memory[i];
        }

        // drill down
        memory[i] = climb_stairs_memory(i + 1, n, memory) +
                climb_stairs_memory(i + 2, n, memory);
        // reverse state
        return memory[i];
    }


    // fibonacci
    public int fibonacciSolution(int n) {
        int f1 = 1;
        int f2 = 2;
        for (int i = 3; i <= n; i++) {
            int f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f2;
    }


}
