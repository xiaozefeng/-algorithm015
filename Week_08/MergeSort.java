package org.mickey.homework.week8;

/**
 * @author mickey
 * @date 10/24/20 15:34
 */
public class MergeSort {

    public static void mergeSort(int[] arr, int left, int right) {
        if (right <= left) return;
        int mid = (right - left) >> 1;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right)
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        if (temp.length >= 0) System.arraycopy(temp, 0, arr, 0, temp.length);
    }
}
