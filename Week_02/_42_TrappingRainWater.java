package org.mickey.homework.week2;

/**
 * @author mickey
 * @date 2020/9/1 21:01
 */
public class _42_TrappingRainWater {

    public int trap(int[] height) {
        int result = 0;
        int size = height.length;
        for (int i = 0; i < size - 1; i++) {
            int max_left = 0;
            int max_right = 0;
            for (int j = i; j >= 0; j--) {
                max_left = Math.max(max_left, height[j]);
            }
            for (int j = i; j < size; j++) {
                max_right = Math.max(max_right, height[j]);
            }

            result += Math.min(max_left, max_right) - height[i];
        }
        return result;
    }
}
