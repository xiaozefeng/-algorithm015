package org.mickey.homework.week4;

/**
 * @author mickey
 * @date 2020/9/15 11:21
 */
public class _49_Sprtx {

    // 秀珍计算器
    public int mySqrt(int x) {
        if (x== 0) return 0;
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }


    // binary search
    public int binarySearch(int x) {
        if (x == 0 || x == 1) return x;

        long left = 1;
        long right =x;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid *mid> x){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return (int) right;
    }

}
