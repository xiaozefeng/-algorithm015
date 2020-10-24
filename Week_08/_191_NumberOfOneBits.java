package org.mickey.homework.week8;

public class _191_NumberOfOneBits {

    public int solution1(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) bits++;
            mask <<= 1;
        }
        return bits;
    }


    public int solution2(int n) {
        int bits = 0;
        while (n != 0) {
            bits++;
            n &= (n - 1); // 去掉1
        }
        return bits;
    }
}
