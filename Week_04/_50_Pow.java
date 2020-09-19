package org.mickey.homework.week4;

/**
 * @author mickey
 * @date 9/18/20 08:31
 */
public class _50_Pow {

    public double myPow(double x, int n) {
        return n > 0 ? quickMul(x, n) : 1.0 / quickMul(x, -n);
    }

    private double quickMul(double x, int n) {
        if (n == 0)
            return 1.0;
        double y = quickMul(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }
}
