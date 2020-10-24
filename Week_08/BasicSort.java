package org.mickey.homework.week8;


/**
 * @author mickey
 * @date 10/24/20 11:47
 */
public class BasicSort {
    // 冒泡排序
    public void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - 1 - i; j++)
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
    }

    private void swap(int[] arr, int j, int i) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    // 选择排序
    public void selectionSort(int[] arr) {
        int minIndex;
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] > arr[minIndex])
                    minIndex = j;
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    // 插入排序
    public void insertionSort(int [] arr) {
        int preIndex;
        int current;
        for (int i = 1; i < arr.length; i++) {
            preIndex = i - 1;
            current = arr[i];
            while (preIndex >=0 &&arr[preIndex]> current){
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
    }


}
