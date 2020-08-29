package org.mickey.homework.week1;

/**
 * @author mickey
 * @date 8/29/20 01:52
 */
public class _66_PlusOne {


    public int[] plusOne(int[] digits) {
        // 从后往前遍历, 发现除了是9 , 其他情况都加1， 就直接返回即可
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }

        }
        // 表示全部是999
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
