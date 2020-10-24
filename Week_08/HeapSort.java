package org.mickey.homework.week8;

import java.util.PriorityQueue;

/**
 * @author mickey
 * @date 10/24/20 15:41
 */
public class HeapSort {

    public static void heapSort(int[] arr) {
        if (arr.length == 0) return;
        int len = arr.length;

        for (int i = len / 2 - 1; i >= 0; i--)
            heapify(arr, len, i);


        for (int i = len - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, len, i);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void heapify(int[] arr, int len, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < len && arr[left] > arr[largest])
            largest = left;

        if (right < len && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, len, largest);
        }
    }


    public static void heapSort2(int []arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : arr)
            pq.add(num);

        for (int i = 0; i < arr.length; i++)
            arr[i] = pq.remove();
    }
}
