package org.mickey.homework.week2;

/**
 * @author mickey
 * @date 2020/9/1 15:25
 */
public class _189_RotateArray {

    public void rotateBruteForce(int[] nums, int k) {
        // 暴力解法 ，遍历k次， 每次移动一位
        k %= nums.length;
        int previous, temp;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }


    public void rotateUsingExtraArray(int[] nums, int k) {
        int[] extraArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            extraArray[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(extraArray, 0, nums, 0, extraArray.length);
    }


    // 三次翻转

    public void rotateThreeReverse(int[] nums, int k) {
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end]  =temp;
            start++;
            end--;
        }
    }


}
