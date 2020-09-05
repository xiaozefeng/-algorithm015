package org.mickey.homework.week2;

import java.util.Arrays;

/**
 * @author mickey
 * @date 2020/9/1 16:49
 */
public class _88_MergeSortedArray {

    public void mergeUsingCopyAndSort(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    public void mergeUsingFrontDoublePointer(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        int p1 = 0;
        int p2 = 0;

        int p = 0;

        while (p1 < m && p2 < n)
            nums1[p] = nums1_copy[p1] < nums2[p2] ? nums1_copy[p1++] : nums2[p2]++;

        if (p1 < m)
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);

        if (p2 < n)
            System.arraycopy(nums1_copy, p2, nums1, p1 + p2, m + n - p1 - p2);
    }

    public void mergeUsingDoublePointer(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1; // valid elements last index with nums1
        int p2 = n - 1; // last index with nums2
        int p3 = m + n - 1; // last index with nums1

        while (p1 >= 0 && p2 >= 0)
            nums1[p3--] = nums1[p1] >= nums2[p2] ? nums1[p1--] : nums2[p2--];

        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (j >= 0) {
            nums1[k--] = i >= 0 && nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
    }

}