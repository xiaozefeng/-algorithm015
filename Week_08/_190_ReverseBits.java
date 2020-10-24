package org.mickey.homework.week8;

public class _190_ReverseBits {
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans  = (ans <<1) + (n &1);
            n >>=1;
        }
        return ans;
    }
}

