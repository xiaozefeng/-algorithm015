package org.mickey.homework.week8;

/**
 * @author mickey
 * @date 10/24/20 15:24
 */
public class QuickSort {

    public static void quickSort(int[] arr, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(arr, begin, end);
        quickSort(arr, begin, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    private static int partition(int[] arr, int begin, int end) {
        // pivot: 标杆位置 , counter: 小于pivot的元素个数
        int counter = begin;
        for (int i = begin; i < end; i++)
            if (arr[i] < arr[end]) swap(arr, i, counter++);

        swap(arr, end, counter);
        return counter;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
