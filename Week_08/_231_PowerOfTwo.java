package org.mickey.homework.week8;

public class _231_PowerOfTwo {

    public boolean solution1(int n) {
        if (n == 0) return false;
        while (n%2==0) n /= 2;
        return n == 1;
    }

    public boolean solution2(int n) {
        if (n == 0) return false;
        while ((n&1)==0) n >>= 2;
        return n == 1;
    }

    public boolean solution3(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}

