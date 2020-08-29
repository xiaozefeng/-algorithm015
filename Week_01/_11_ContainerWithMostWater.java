package org.mickey.homework.week1;

/**
 * @author mickey
 * @date 8/29/20 16:13
 */
public class _11_ContainerWithMostWater {

    public static void main(String[] args) {
        new _11_ContainerWithMostWater().bruteForce(new int[]{1, 2, 3, 4});
    }

    public int bruteForce(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return max;
    }


    /**
     * 左右夹逼, 定义左右两个指针， 哪边的高度较小，
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int max = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int miniHeight = height[l] < height[r] ? height[l++] : height[r--];
            int area = miniHeight * (r - l + 1);
            max = Math.max(max, area);
        }
        return max;
    }


}
