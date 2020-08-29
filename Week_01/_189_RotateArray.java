package org.mickey.homework.week1;

/**
 * @author mickey
 * @date 2020/8/28 18:28
 */
public class _189_RotateArray {

    public static void main(String[] args) {
        new _189_RotateArray().bruteForce(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }

    public void bruteForce(int[] nums, int k) {
        // 暴力法
        k %= nums.length; // 加快旋转， 如果 k=10 nums.length =9 那么只需要移动一次
        int lastElement, temp;
        for (int i = 0; i < k; i++) {
            lastElement = nums[nums.length - 1]; // 每次都是最后一个元素
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = lastElement;
                lastElement = temp;
            }
        }
    }

    public void extractArray(int[] nums, int k) {
        int[] extract = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            extract[(k + i) % nums.length] = nums[i];
        for (int i = 0; i < extract.length; i++)
            nums[i] = extract[i];
    }


    public void threeReverse(int[] nums, int k) {
        // 三次翻转
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        int temp;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


}
