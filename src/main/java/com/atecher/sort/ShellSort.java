package com.atecher.sort;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {

    public static void shellSort(int[] array) {
        int n = array.length;
        int h = 1;
        //初始最大步长
        while (h < n / 3) h = h * 3 + 1;
        while (h >= 1) {
            //从第二个元素开始
            for (int i = 1; i < n; i++) {
                //从第i个元素开始，依次次和前面已经排好序的i-h个元素比较，如果小于，则交换
                for (int j = i; j >= h; j = j - h) {
                    if (array[j] < (array[j - h])) {
                        swap(array, j, j - h);
                    } else//如果大于，则不用继续往前比较了，因为前面的元素已经排好序，比较大的大就是教大的了。
                        break;
                }
            }
            //步长除3递减
            h = h / 3;
        }
    }

    private static void swap(int[] array, int i, int min) {
        int temp = array[i];
        array[i] = array[min];
        array[min] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 1, 4, 2, 4, 2, 3, 2, 4, 7, 6, 6, 7, 5, 5, 7, 7};
        System.out.println("Before SelectionSort:");
        System.out.println(Arrays.toString(array));
        shellSort(array);
        System.out.println("After SelectionSort:");
        System.out.println(Arrays.toString(array));
    }

}
