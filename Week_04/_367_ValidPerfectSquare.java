package org.mickey.homework.week4;

/**
 * @author mickey
 * @date 2020/9/15 11:42
 */
public class _367_ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
       if (num <2) return true;
        long x = num / 2;
        while (x * x > num)
            x = (x + num / x) / 2;

        return x * x == num;
    }
}
